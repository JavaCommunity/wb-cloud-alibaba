package com.wb.oauth.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: SecurityOauthProperties
 * @Package: com.wb.oauth.service.config
 * @Description: the security oauth properties
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
@ConfigurationProperties(
        prefix = "wb-cloud.security-oauth"
)
public class SecurityOauthProperties {

    //  the token store properties configuration
    private TokenStoreProperties tokenStore;

    public TokenStoreProperties getTokenStore() {
        return tokenStore;
    }

    public void setTokenStore(TokenStoreProperties tokenStore) {
        this.tokenStore = tokenStore;
    }
}
