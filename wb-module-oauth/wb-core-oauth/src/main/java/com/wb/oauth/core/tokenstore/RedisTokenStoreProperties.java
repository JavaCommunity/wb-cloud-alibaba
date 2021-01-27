package com.wb.oauth.core.tokenstore;

import com.wb.oauth.core.factorybean.RedisTokenStoreFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.util.ObjectUtils;

import java.util.Map;

/**
 * @ClassName: RedisTokenStoreProperties
 * @Package: com.wb.oauth.core.tokenstore
 * @Description: the redis token store properties
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class RedisTokenStoreProperties extends AbstractTokenStoreProperties {

    public RedisTokenStoreProperties() {
        super(RedisTokenStoreFactoryBean.class);
    }

    @Override
    public void check(DefaultListableBeanFactory beanFactory) {
        RedisConnectionFactory redisConnectionFactory = beanFactory.getBean(RedisConnectionFactory.class);
        if (ObjectUtils.isEmpty(redisConnectionFactory)) {
            throw new IllegalArgumentException("'redisConnectionFactory' must not be null！");
        }
    }

    @Override
    public void putPropertyReference(Map<String, String> propertyReferenceMap) {
        propertyReferenceMap.put("redisConnectionFactory", "redisConnectionFactory");
    }
}
