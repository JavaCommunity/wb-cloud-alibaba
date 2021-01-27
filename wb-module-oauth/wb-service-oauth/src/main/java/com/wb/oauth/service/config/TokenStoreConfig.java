package com.wb.oauth.service.config;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @ClassName: TokenStoreConfig
 * @Package: com.wb.oauth.service.config
 * @Description: the token store config
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties({SecurityOauthProperties.class})
public class TokenStoreConfig {

    @ConditionalOnMissingBean
    @Bean(name = "tokenStoreHandler")
    public TokenStoreHandler tokenStoreHandler(DefaultListableBeanFactory beanFactory,
                                               SecurityOauthProperties tokenStoreProperties,
                                               Environment env) {
        return new TokenStoreHandler(beanFactory, tokenStoreProperties, env);
    }
}
