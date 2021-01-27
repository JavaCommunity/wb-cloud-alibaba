package com.wb.oauth.core.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @ClassName: RedisTokenStoreFactoryBean
 * @Package: com.wb.oauth.core.factorybean
 * @Description: the redis token store factory bean
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class RedisTokenStoreFactoryBean implements FactoryBean<RedisTokenStore> {

    //  the redis connection factory
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public RedisTokenStore getObject() throws Exception {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Override
    public Class<?> getObjectType() {
        return RedisTokenStore.class;
    }

    public RedisConnectionFactory getRedisConnectionFactory() {
        return redisConnectionFactory;
    }

    public void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }
}
