package com.wb.oss.component.config;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @ClassName: OssAutoConfiguration
 * @Package: com.wb.oss.component.config
 * @Description: the oss auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(
        name = "wb-cloud.oss.enabled",
        havingValue = "true",
        matchIfMissing = true
)
@ComponentScan({"com.wb.oss.component"})
@EnableConfigurationProperties({OssProperties.class})
public class OssAutoConfiguration {

    @ConditionalOnMissingBean
    @Bean(name = "ossClientHandler", initMethod = "determineOssClient")
    public OssClientHandler ossClientHandler(DefaultListableBeanFactory beanFactory,
                                             OssProperties ossProperties,
                                             Environment env) {
        return new OssClientHandler(beanFactory, ossProperties, env);
    }
}
