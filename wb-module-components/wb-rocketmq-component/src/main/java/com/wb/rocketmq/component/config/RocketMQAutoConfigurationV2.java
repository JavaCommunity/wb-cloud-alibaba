package com.wb.rocketmq.component.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RocketMQAutoConfigurationV2
 * @Package: com.wb.rocketmq.component.config
 * @Description: the rocket mq auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/4/10
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(
        name = "wb-cloud.rocketmq.enabled",
        havingValue = "true",
        matchIfMissing = true
)
@EnableConfigurationProperties({RocketMQProperties.class})
public class RocketMQAutoConfigurationV2 implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(RocketMQAutoConfigurationV2.class);

    @Bean
    public RocketMQBeanFactoryPostProcessor rocketMQBeanFactoryPostProcessor() {
        return new RocketMQBeanFactoryPostProcessor();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[RocketMQ Starter] Init RocketMQ.");
    }
}
