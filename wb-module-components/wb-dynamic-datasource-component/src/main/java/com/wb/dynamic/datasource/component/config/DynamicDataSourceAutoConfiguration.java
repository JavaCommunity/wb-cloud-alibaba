package com.wb.dynamic.datasource.component.config;

import com.wb.dynamic.datasource.component.aop.DynamicDataSourceAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName: DynamicDataSourceAutoConfiguration
 * @Package: com.wb.dynamic.datasource.component.config
 * @Description: the dynamic datasource auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(
        name = "wb-cloud.dynamic-datasource.enabled",
        havingValue = "true",
        matchIfMissing = true
)
//  exposeProxy=true enabled aopContext
@EnableAspectJAutoProxy(exposeProxy = true)
public class DynamicDataSourceAutoConfiguration implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DynamicDataSourceAutoConfiguration.class);

    /**
     * the create data source properties
     *
     * @return the data source properties
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties defaultDataSource() {
        return new DataSourceProperties();
    }

    /**
     * the create dynamic data source properties
     *
     * @return the dynamic data source properties
     */
    @Bean
    @ConfigurationProperties(prefix = "wb-cloud.dynamic-datasource")
    public DynamicDataSourceProperties dynamicDataSource() {
        return new DynamicDataSourceProperties();
    }

    /**
     * the create default routing datasource
     *
     * @return the default routing datasource
     */
    @Bean
    public DataSource defaultRoutingDataSource() {
        return new DefaultRoutingDataSource();
    }

    /**
     * the create datasource transaction manager
     *
     * @return the datasource transaction manager
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(defaultRoutingDataSource());
    }

    /**
     * the create dynamic datasource aspect
     *
     * @return the dynamic datasource aspect
     */
    @Bean
    public DynamicDataSourceAspect dynamicDataSourceAspect() {
        return new DynamicDataSourceAspect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Init Dynamic Datasource.");
    }
}
