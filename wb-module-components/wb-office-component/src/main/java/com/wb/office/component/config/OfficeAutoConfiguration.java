package com.wb.office.component.config;

import com.wb.office.component.handler.OfficeFileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

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

    //  the configurers
    private final OfficeConfigurerComposite composite = new OfficeConfigurerComposite();

    // the slf4j log
    private static final Logger log = LoggerFactory.getLogger(OfficeAutoConfiguration.class);

    /**
     * set configurer
     *
     * @param configurer the configurer
     */
    @Autowired(required = false)
    public void setConfigurer(OfficeConfigurer configurer) {
        if (!ObjectUtils.isEmpty(configurer)) {
            this.composite.setConfigurer(configurer);
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public OfficeFileHandler officeFileHandler() {
        OfficeFileHandler officeFileHandler = this.composite.addOfficeFileHandler();
        return officeFileHandler;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Init Office.");
    }
}
