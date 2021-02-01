package com.wb.oss.component.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
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
 * @ClassName: OssClientHandler
 * @Package: com.wb.oss.component.config
 * @Description: the oss client handler
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class OssClientHandler extends InstantiationAwareBeanPostProcessorAdapter {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(OssClientHandler.class);

    //  the default listable bean factory
    private final DefaultListableBeanFactory beanFactory;

    //  the oss properties
    private final OssProperties ossProperties;

    //  the environment
    private final Environment env;

    /**
     * constructs a new ossClientHandler with specified beanFactory and ossProperties and env
     *
     * @param beanFactory   the beanFactory
     * @param ossProperties the ossProperties
     * @param env           the env
     */
    public OssClientHandler(DefaultListableBeanFactory beanFactory, OssProperties ossProperties, Environment env) {
        this.beanFactory = beanFactory;
        this.ossProperties = ossProperties;
        this.env = env;
    }

    /**
     * the determine oss client
     */
    public void determineOssClient() {
        Assert.notNull(ossProperties, "'ossProperties' must not be null！");

        String type = ossProperties.getType();
        type = StringUtils.isEmpty(type) ? OssConstants.DEFAULT_OSS_SERVER_TYPE : type;
        log.info("Determine Oss Client Type: {}", type);

        AbstractOssProperties abstractOssProperties = ossProperties.getOssProperties(type);
        Assert.notNull(abstractOssProperties, "not found match oss properties：" + type);
        abstractOssProperties.setEnv(env);
        abstractOssProperties.check(this.beanFactory);
        registryBean(abstractOssProperties, OssConstants.DEFAULT_TOKEN_STORE_PREFIX + type);
    }

    /**
     * the registry bean to spring container
     *
     * @param ossProperties     the oss properties
     * @param ossPropertiesName the oss properties name
     */
    public void registryBean(final AbstractOssProperties ossProperties, String ossPropertiesName) {
        Map<String, Object> propertyMap = (Map) Arrays.stream(ossProperties.getClass().getDeclaredFields()).collect(HashMap::new, (m, v) -> {
            try {
                v.setAccessible(true);
                m.put(v.getName(), v.get(ossProperties));
            } catch (IllegalAccessException var5) {
                throw new RuntimeException("[Oss Starter] properties field: " + v.getName() + " invoke error", var5);
            }
        }, HashMap::putAll);
        Class<?> factoryBeanResource = ossProperties.getFactoryBeanResource();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(factoryBeanResource);

        propertyMap.put("ossProperties", ossProperties);
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
        ossProperties.putPropertyReference(propertyReferenceMap);
        propertyReferenceMap.forEach((propertyName, propertyValue) -> {
            Field field = ReflectionUtils.findField(factoryBeanResource, propertyName);
            if (!ObjectUtils.isEmpty(field)) {
                Optional.ofNullable(propertyValue).ifPresent((v) -> {
                    builder.addPropertyReference(propertyName, v);
                });
            }
        });

        this.beanFactory.registerBeanDefinition(ossPropertiesName, builder.getBeanDefinition());
        this.beanFactory.getBean(ossPropertiesName);
    }
}
