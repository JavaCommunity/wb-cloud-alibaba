package com.wb.office.component.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: OfficeAutoConfiguration
 * @Package: com.wb.office.component.config
 * @Description: the office auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/1/28
 * @Version: 1.0
 */
@Configuration
@ComponentScan({"com.wb.office.component"})
@EnableConfigurationProperties({OfficeProperties.class})
@ConditionalOnProperty(
        name = "wb-cloud.office.enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class OfficeAutoConfiguration implements InitializingBean {

    // the slf4j log
    private static final Logger log = LoggerFactory.getLogger(OfficeAutoConfiguration.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Init Office.");
    }
}
