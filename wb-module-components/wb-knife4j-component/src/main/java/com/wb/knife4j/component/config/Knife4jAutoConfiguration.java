package com.wb.knife4j.component.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: Knife4jAutoConfiguration
 * @Package: com.wb.knife4j.component.config
 * @Description: the knife4j auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@EnableKnife4j
@EnableSwagger2
@Configuration
@AutoConfigureBefore(Knife4jConfig.class)
@EnableConfigurationProperties({Knife4jProperties.class})
@Import({Knife4jConfig.class, BeanValidatorPluginsConfiguration.class})
@ConditionalOnProperty(
        name = {"wb.knife4j.enabled"},
        matchIfMissing = true
)
public class Knife4jAutoConfiguration implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(Knife4jAutoConfiguration.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Init Knife4j ...");
    }
}
