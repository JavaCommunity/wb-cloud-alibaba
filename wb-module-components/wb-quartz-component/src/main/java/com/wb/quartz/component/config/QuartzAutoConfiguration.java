package com.wb.quartz.component.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: QuartzAutoConfiguration
 * @Package: com.wb.quartz.component.client
 * @Description: the quartz auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.wb.quartz.component"})
@ConditionalOnProperty(
        name = "wb-cloud.quartz.enabled",
        havingValue = "true",
        matchIfMissing = true
)
@EnableConfigurationProperties({QuartzProperties.class})
public class QuartzAutoConfiguration implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(QuartzAutoConfiguration.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[Quartz Starter] Init Quartz.");
    }
}
