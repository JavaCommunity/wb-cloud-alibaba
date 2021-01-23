package com.wb.seata.example.config;

import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @ClassName: SeataDataSourceProxyConfig
 * @Package: com.wb.seata.example.config
 * @Description: the seata data source proxy configuration
 * @Author：[bo.wang]
 * @Date: 2021/1/23
 * @Version: 1.0
 */
@Configuration
public class SeataDataSourceProxyConfig {

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }
}
