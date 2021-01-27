package com.wb.oauth.core.tokenstore;

import com.wb.oauth.core.factorybean.JwtTokenStoreFactoryBean;

/**
 * @ClassName: JwtTokenStoreProperties
 * @Package: com.wb.oauth.core.tokenstore
 * @Description: the jwt token store properties
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class JwtTokenStoreProperties extends AbstractTokenStoreProperties {

    //  the jwt token converter signing key
    private String signingKey;

    public JwtTokenStoreProperties() {
        super(JwtTokenStoreFactoryBean.class);
    }

    public String getSigningKey() {
        return signingKey;
    }

    public void setSigningKey(String signingKey) {
        this.signingKey = signingKey;
    }
}
