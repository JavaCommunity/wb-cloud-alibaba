package com.wb.oauth.service.config;

import com.wb.oauth.core.tokenstore.AbstractTokenStoreProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: TokenStoreHandler
 * @Package: com.wb.oauth.core.custom
 * @Description: the token store handler
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class TokenStoreHandler implements InitializingBean {

    //  the default token store prefix
    private static final String DEFAULT_TOKEN_STORE_PREFIX = "wb-cloud-";

    //  the default token store suffix
    private static final String DEFAULT_TOKEN_STORE_SUFFIX = "-token-store";

    //  the default listable bean factory
    private final DefaultListableBeanFactory beanFactory;

    //  the security oauth properties
    private final SecurityOauthProperties securityOauthProperties;

    //  the environment
    private final Environment env;

    public TokenStoreHandler(DefaultListableBeanFactory beanFactory, SecurityOauthProperties securityOauthProperties, Environment env) {
        this.beanFactory = beanFactory;
        this.securityOauthProperties = securityOauthProperties;
        this.env = env;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.securityOauthProperties, "'securityOauthProperties' must not be null！");

        TokenStoreProperties tokenStoreProperties = securityOauthProperties.getTokenStore();
        Assert.notNull(tokenStoreProperties, "'tokenStoreProperties' must not be null！");

        String tokenStoreType = tokenStoreProperties.getType();
        tokenStoreType = StringUtils.isEmpty(tokenStoreType) ? TokenStoreProperties.DEFAULT_TOKEN_STORE_TYPE : tokenStoreType;
        AbstractTokenStoreProperties abstractTokenStoreProperties = tokenStoreProperties.getTokenStoreProperties(tokenStoreType);
        Assert.notNull(abstractTokenStoreProperties, "not found match token store：" + tokenStoreType);

        abstractTokenStoreProperties.setEnv(env);
        abstractTokenStoreProperties.check(this.beanFactory);
        this.registryBean(abstractTokenStoreProperties, DEFAULT_TOKEN_STORE_PREFIX + tokenStoreType + DEFAULT_TOKEN_STORE_SUFFIX);
    }

    /**
     * the registry bean to spring container
     *
     * @param tokenStoreProperties the token store properties
     * @param tokenStoreName       the token store name
     */
    public void registryBean(final AbstractTokenStoreProperties tokenStoreProperties, String tokenStoreName) {
        Map<String, Object> propertyMap = (Map) Arrays.stream(tokenStoreProperties.getClass().getDeclaredFields()).collect(HashMap::new, (m, v) -> {
            try {
                v.setAccessible(true);
                m.put(v.getName(), v.get(tokenStoreProperties));
            } catch (IllegalAccessException var5) {
                throw new RuntimeException("[Oauth Starter] Token Store field: " + v.getName() + " invoke error", var5);
            }
        }, HashMap::putAll);
        Class<?> factoryBeanResource = tokenStoreProperties.getFactoryBeanResource();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(factoryBeanResource);

        //  load property value
        propertyMap.forEach((propertyName, propertyValue) -> {
            Field field = ReflectionUtils.findField(factoryBeanResource, propertyName);
            if (!ObjectUtils.isEmpty(field)) {
                Optional.ofNullable(propertyValue).ifPresent((v) -> {
                    builder.addPropertyValue(propertyName, v);
                });
            }
        });

        //  load property reference
        Map<String, String> propertyReferenceMap = new HashMap<>(16);
        tokenStoreProperties.putPropertyReference(propertyReferenceMap);
        propertyReferenceMap.forEach((propertyName, propertyValue) -> {
            Field field = ReflectionUtils.findField(factoryBeanResource, propertyName);
            if (!ObjectUtils.isEmpty(field)) {
                Optional.ofNullable(propertyValue).ifPresent((v) -> {
                    builder.addPropertyReference(propertyName, v);
                });
            }
        });
        this.beanFactory.registerBeanDefinition(tokenStoreName, builder.getBeanDefinition());
        this.beanFactory.getBean(tokenStoreName);
    }
}
