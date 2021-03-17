package com.wb.sms.component.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @ClassName: SmsAutoConfiguration
 * @Package: com.wb.sms.component.config
 * @Description: the sms auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(
        name = "wb-cloud.sms.enabled",
        havingValue = "true",
        matchIfMissing = true
)
@ComponentScan({"com.wb.sms.component"})
@EnableConfigurationProperties({SmsProperties.class})
public class SmsAutoConfiguration implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(SmsAutoConfiguration.class);

    @ConditionalOnMissingBean
    @Bean(name = "smsClientHandler", initMethod = "initSmsClient")
    public SmsClientHandler smsClientHandler(DefaultListableBeanFactory beanFactory,
                                             SmsProperties smsProperties,
                                             Environment env) {
        return new SmsClientHandler(beanFactory, smsProperties, env);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[Sms Starter] Init Sms.");
    }
}
