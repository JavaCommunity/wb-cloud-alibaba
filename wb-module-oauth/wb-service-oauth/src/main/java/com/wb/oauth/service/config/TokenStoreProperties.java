package com.wb.oauth.service.config;

import com.wb.oauth.core.tokenstore.AbstractTokenStoreProperties;
import com.wb.oauth.core.tokenstore.JdbcTokenStoreProperties;
import com.wb.oauth.core.tokenstore.JwtTokenStoreProperties;
import com.wb.oauth.core.tokenstore.RedisTokenStoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;

/**
 * @ClassName: TokenStoreProperties
 * @Package: com.wb.oauth.service.config
 * @Description: the token store properties
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class TokenStoreProperties {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(TokenStoreProperties.class);

    //  the default token store type
    public static final String DEFAULT_TOKEN_STORE_TYPE = "redis";

    //  the token store type
    private String type;

    //  the jwt token store properties
    private JwtTokenStoreProperties jwt;

    //  the redis token store properties
    private RedisTokenStoreProperties redis;

    //  the jdbc token store properties
    private JdbcTokenStoreProperties jdbc;

    /**
     * constructs a new token store properties
     */
    public TokenStoreProperties() {
        this.type = DEFAULT_TOKEN_STORE_TYPE;
        this.jwt = new JwtTokenStoreProperties();
        this.redis = new RedisTokenStoreProperties();
        this.jdbc = new JdbcTokenStoreProperties();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JwtTokenStoreProperties getJwt() {
        return jwt;
    }

    public void setJwt(JwtTokenStoreProperties jwt) {
        this.jwt = jwt;
    }

    public RedisTokenStoreProperties getRedis() {
        return redis;
    }

    public void setRedis(RedisTokenStoreProperties redis) {
        this.redis = redis;
    }

    public JdbcTokenStoreProperties getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTokenStoreProperties jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * get token store properties with the specified type
     *
     * @param type the type
     * @return the Abstract token store properties
     */
    public AbstractTokenStoreProperties getTokenStoreProperties(String type) {
        Assert.hasLength(type, "'type' must not be null！");

        try {
            Field declaredField = this.getClass().getDeclaredField(type);
            declaredField.setAccessible(true);
            AbstractTokenStoreProperties abstractTokenStoreProperties = (AbstractTokenStoreProperties) declaredField.get(this);
            if (ObjectUtils.isEmpty(abstractTokenStoreProperties)) {
                log.error("[Oauth Starter] Token Store won't loaded：" + type);
                return null;
            }
            return abstractTokenStoreProperties;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
