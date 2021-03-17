package com.wb.sms.component.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: SmsClientHandler
 * @Package: com.wb.sms.component.config
 * @Description: the sms client handler
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class SmsClientHandler extends InstantiationAwareBeanPostProcessorAdapter {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(SmsClientHandler.class);

    //  the default listable bean factory
    private final DefaultListableBeanFactory beanFactory;

    //  the sms properties
    private final SmsProperties smsProperties;

    //  the environment
    private final Environment env;

    /**
     * constructs a new smsClientHandler with specified beanFactory and smsProperties and env.
     *
     * @param beanFactory   the bean factory
     * @param smsProperties the sms properties
     * @param env           the environment
     */
    public SmsClientHandler(DefaultListableBeanFactory beanFactory, SmsProperties smsProperties, Environment env) {
        this.beanFactory = beanFactory;
        this.smsProperties = smsProperties;
        this.env = env;
    }

    /**
     * the init sms client
     */
    public void initSmsClient() {
        Assert.notNull(smsProperties, "'smsProperties' must not be null！");

        Field[] allField = smsProperties.getAllField();
        Arrays.asList(allField).stream().forEach((field) -> {
            field.setAccessible(true);
            Object properties = ReflectionUtils.getField(field, smsProperties);
            if (!ObjectUtils.isEmpty(properties) && properties instanceof AbstractSmsProperties) {
                AbstractSmsProperties abstractSmsProperties = (AbstractSmsProperties) properties;
                abstractSmsProperties.setEnv(env);
                abstractSmsProperties.check(this.beanFactory);
                registryBean(abstractSmsProperties, field.getName() + "SmsFactoryBean");
            }
        });
    }

    /**
     * the registry bean to spring container
     *
     * @param abstractSmsProperties the abstract sms properties
     * @param factoryBeanName       the factory bean name
     */
    public void registryBean(final AbstractSmsProperties abstractSmsProperties, String factoryBeanName) {
        Map<String, Object> propertyMap = (Map) Arrays.stream(abstractSmsProperties.getClass().getDeclaredFields()).collect(HashMap::new, (m, v) -> {
            try {
                v.setAccessible(true);
                m.put(v.getName(), v.get(abstractSmsProperties));
            } catch (IllegalAccessException var5) {
                throw new RuntimeException("[Sms Starter] sms properties field: " + v.getName() + " invoke error", var5);
            }
        }, HashMap::putAll);
        Class<?> factoryBeanResource = abstractSmsProperties.getFactoryBeanResource();
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
        this.beanFactory.registerBeanDefinition(factoryBeanName, builder.getBeanDefinition());
        this.beanFactory.getBean(factoryBeanName);
        log.info("[Sms Starter] Init Sms Factory Bean：" + factoryBeanName);
    }
}
