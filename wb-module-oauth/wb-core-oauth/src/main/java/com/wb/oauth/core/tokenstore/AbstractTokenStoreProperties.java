package com.wb.oauth.core.tokenstore;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @ClassName: AbstractTokenStoreProperties
 * @Package: com.wb.oauth.core.tokenstore
 * @Description: the abstract token store properties
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
public class AbstractTokenStoreProperties {

//    //  the factory bean name
//    private final String factoryBeanName;

    //  the factory bean resource
    private final Class<?> factoryBeanResource;

    //  the environment
    private Environment env;

    public AbstractTokenStoreProperties(Class<?> factoryBeanResource) {
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
     * the put property reference
     *
     * @param propertyReferenceMap the property reference map
     */
    public void putPropertyReference(final Map<String, String> propertyReferenceMap) {
    }

    public Class<?> getFactoryBeanResource() {
        return factoryBeanResource;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }
}
