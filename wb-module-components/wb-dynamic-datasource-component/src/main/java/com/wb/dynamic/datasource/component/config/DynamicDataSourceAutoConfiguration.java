package com.wb.dynamic.datasource.component.config;

import com.wb.dynamic.datasource.component.aop.DynamicDataSourceAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        name = "knx.dynamic-datasource.enabled",
        matchIfMissing = true
)
public class DynamicDataSourceAutoConfiguration {

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
    @ConfigurationProperties(prefix = "knx.dynamic-datasource")
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
}
