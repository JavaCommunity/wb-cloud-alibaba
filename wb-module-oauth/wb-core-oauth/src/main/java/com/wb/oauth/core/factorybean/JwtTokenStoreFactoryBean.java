package com.wb.oauth.core.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @ClassName: JwtTokenStoreFactoryBean
 * @Package: com.wb.oauth.core.factorybean
 * @Description: the jwt token store factory bean
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class JwtTokenStoreFactoryBean implements FactoryBean<JwtTokenStore> {

    //  the signing key
    private String signingKey;

    @Override
    public JwtTokenStore getObject() throws Exception {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(signingKey);
        JwtTokenStore jwtTokenStore = new JwtTokenStore(tokenConverter);
        return jwtTokenStore;
    }

    @Override
    public Class<?> getObjectType() {
        return JwtTokenStore.class;
    }

    public String getSigningKey() {
        return signingKey;
    }

    public void setSigningKey(String signingKey) {
        this.signingKey = signingKey;
    }
}
