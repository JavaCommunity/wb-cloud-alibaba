package com.wb.oauth.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @ClassName: ClientDetailsConfig
 * @Package: com.wb.oauth.service.config
 * @Description: the client details config
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
@Configuration
public class ClientDetailsConfig {

    @Primary
    @Bean(name = "clientDetails")
    public ClientDetailsService clientDetailsService(DataSource dataSource) {
        return new JdbcClientDetailsService(dataSource);
    }
}
