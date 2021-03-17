package com.wb.sms.component.config;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.env.Environment;

/**
 * @ClassName: AbstractSmsProperties
 * @Package: com.wb.sms.component.config
 * @Description: the abstract sms properties
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public abstract class AbstractSmsProperties {

    //  the factory bean resource
    private final Class<?> factoryBeanResource;

    //  the environment
    private Environment env;

    /**
     * constructs a new abstractSmsProperties with the specified factoryBeanResource
     *
     * @param factoryBeanResource the factory bean resource
     */
    public AbstractSmsProperties(Class<?> factoryBeanResource) {
        this.factoryBeanResource = factoryBeanResource;
    }

    /**
     * the check environment and bean
     *
     * @param beanFactory the bean factory
     */
    public abstract void check(final DefaultListableBeanFactory beanFactory);

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
