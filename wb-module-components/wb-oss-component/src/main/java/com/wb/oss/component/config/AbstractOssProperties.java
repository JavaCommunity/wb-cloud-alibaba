package com.wb.oss.component.config;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @ClassName: AbstractOssProperties
 * @Package: com.wb.oss.component.config
 * @Description: the abstract oss properties
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class AbstractOssProperties {

    //  the factory bean resource
    private final Class<?> factoryBeanResource;

    //  the environment
    private Environment env;

    /**
     * constructs a new abstractOssProperties with the specified factoryBeanResource
     *
     * @param factoryBeanResource the factory bean resource
     */
    public AbstractOssProperties(Class<?> factoryBeanResource) {
        this.factoryBeanResource = factoryBeanResource;
    }

    /**
     * the check environment and bean
     *
     * @param beanFactory the bean factory
     */
    public void check(final DefaultListableBeanFactory beanFactory) {
    }

    /**
     * the put property reference map
     *
     * @param propertyReferenceMap the property reference map
     */
    public void putPropertyReference(Map<String, String> propertyReferenceMap) {

    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public Class<?> getFactoryBeanResource() {
        return factoryBeanResource;
    }
}
