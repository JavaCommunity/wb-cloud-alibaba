package com.wb.sign.component.config;

import com.wb.sign.component.client.DefaultSignClient;
import com.wb.sign.component.client.SignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SignAutoConfiguration
 * @Package: com.wb.sign.component.config
 * @Description: the sign auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(
        name = "wb-cloud.sign.enabled",
        havingValue = "true",
        matchIfMissing = true
)
@ComponentScan(basePackages = "com.wb.sign.component")
@EnableConfigurationProperties({SignProperties.class})
public class SignAutoConfiguration implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(SignAutoConfiguration.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[Sign Starter] Init.");
    }
}
