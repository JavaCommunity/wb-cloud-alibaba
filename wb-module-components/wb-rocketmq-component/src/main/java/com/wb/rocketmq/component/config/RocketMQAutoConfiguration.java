package com.wb.rocketmq.component.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.MQAdmin;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.autoconfigure.ListenerContainerConfiguration;
import org.apache.rocketmq.spring.config.RocketMQConfigUtils;
import org.apache.rocketmq.spring.config.RocketMQTransactionAnnotationProcessor;
import org.apache.rocketmq.spring.config.TransactionHandlerRegistry;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Role;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @ClassName: RocketMQAutoConfiguration
 * @Package: com.wb.rocketmq.component.config
 * @Description: the rocket mq auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/4/6
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(
        name = "wb-cloud.rocketmq.enabled",
        havingValue = "true",
        matchIfMissing = true
)
@EnableAutoConfiguration(exclude = {org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration.class})
@AutoConfigureAfter({JacksonAutoConfiguration.class})
@ConditionalOnClass({MQAdmin.class, ObjectMapper.class})
@EnableConfigurationProperties({RocketMQProperties.class})
@Import({JacksonFallbackConfiguration.class, ListenerContainerConfiguration.class})
public class RocketMQAutoConfiguration implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(RocketMQAutoConfiguration.class);

    @Autowired
    private RocketMQProperties rocketMQProperties;

    @Bean
    @ConditionalOnMissingBean(DefaultMQProducer.class)
    public DefaultMQProducer defaultMQProducer() {
        RocketMQProperties.Producer producerConfig = rocketMQProperties.getProducer();
        String nameServer = rocketMQProperties.getNameServer();
        String groupName = producerConfig.getGroup();
        Assert.hasText(nameServer, "[RocketMQ] 'nameServer' must not be null");
        Assert.hasText(groupName, "[RocketMQ] 'producer.group' must not be null");

        DefaultMQProducer producer = null;
        String ak = rocketMQProperties.getProducer().getAccessKey();
        String sk = rocketMQProperties.getProducer().getSecretKey();
        if (!StringUtils.isEmpty(ak) && !StringUtils.isEmpty(sk)) {
            producer = new DefaultMQProducer(groupName, new AclClientRPCHook(new SessionCredentials(ak, sk)),
                    rocketMQProperties.getProducer().isEnableMsgTrace(),
                    rocketMQProperties.getProducer().getCustomizedTraceTopic());
            producer.setVipChannelEnabled(false);
        } else {
            producer = new DefaultMQProducer(groupName, rocketMQProperties.getProducer().isEnableMsgTrace(),
                    rocketMQProperties.getProducer().getCustomizedTraceTopic());
        }
        Assert.notNull(producer, "[RocketMQ] 'producer' must not be null");

        producer.setNamesrvAddr(nameServer);
        producer.setSendMsgTimeout(producerConfig.getSendMessageTimeout());
        producer.setRetryTimesWhenSendFailed(producerConfig.getRetryTimesWhenSendFailed());
        producer.setRetryTimesWhenSendAsyncFailed(producerConfig.getRetryTimesWhenSendAsyncFailed());
        producer.setMaxMessageSize(producerConfig.getMaxMessageSize());
        producer.setCompressMsgBodyOverHowmuch(producerConfig.getCompressMessageBodyThreshold());
        producer.setRetryAnotherBrokerWhenNotStoreOK(producerConfig.isRetryNextServer());
        return producer;
    }

    @Bean(destroyMethod = "destroy")
    @ConditionalOnBean(DefaultMQProducer.class)
    @ConditionalOnMissingBean(RocketMQTemplate.class)
    public RocketMQTemplate rocketMQTemplate(DefaultMQProducer mqProducer, ObjectMapper rocketMQMessageObjectMapper) {
        RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();
        rocketMQTemplate.setProducer(mqProducer);
        rocketMQTemplate.setObjectMapper(rocketMQMessageObjectMapper);
        return rocketMQTemplate;
    }

    @Bean
    @ConditionalOnBean(RocketMQTemplate.class)
    @ConditionalOnMissingBean(TransactionHandlerRegistry.class)
    public TransactionHandlerRegistry transactionHandlerRegistry(RocketMQTemplate template) {
        return new TransactionHandlerRegistry(template);
    }

    @Bean(name = RocketMQConfigUtils.ROCKETMQ_TRANSACTION_ANNOTATION_PROCESSOR_BEAN_NAME)
    @ConditionalOnBean(TransactionHandlerRegistry.class)
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public static RocketMQTransactionAnnotationProcessor transactionAnnotationProcessor(
            TransactionHandlerRegistry transactionHandlerRegistry) {
        return new RocketMQTransactionAnnotationProcessor(transactionHandlerRegistry);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[RocketMQ Starter] Init RocketMQ.");
    }
}
