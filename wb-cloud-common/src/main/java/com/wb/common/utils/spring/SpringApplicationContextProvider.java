package com.wb.common.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;

/**
 * @ClassName: SpringApplicationContextProvider
 * @Package: com.wb.common.utils.spring
 * @Description: the spring application context provider
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
public class SpringApplicationContextProvider implements ApplicationContextAware {

    /**
     * the spring application context
     */
    public static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContextProvider.applicationContext = applicationContext;
    }

    /**
     * gets bean
     *
     * @param beanName the bean name
     * @param <T>
     * @return the bean
     * @throws BeansException
     */
    public static <T> T getBean(String beanName) throws BeansException {
        assertApplicationContext();
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * gets bean
     *
     * @param clz the class
     * @param <T>
     * @return the bean
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        assertApplicationContext();
        return applicationContext.getBean(clz);
    }

    /**
     * assert the application context
     */
    private static void assertApplicationContext() {
        if (SpringApplicationContextProvider.applicationContext == null) {
            throw new ApplicationContextException("'applicationContext' must not be null！");
        }
    }
}
