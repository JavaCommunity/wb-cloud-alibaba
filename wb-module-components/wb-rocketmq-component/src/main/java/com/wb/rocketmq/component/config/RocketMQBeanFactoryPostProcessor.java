package com.wb.rocketmq.component.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;

import java.util.Properties;

/**
 * @ClassName: RocketMQBeanFactoryPostProcessor
 * @Package: com.wb.rocketmq.component.config
 * @Description: the rocket mq bean factory post processor
 * @Author：[bo.wang]
 * @Date: 2021/4/10
 * @Version: 1.0
 */
public class RocketMQBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        StandardEnvironment env = (StandardEnvironment) beanFactory.getBean(Environment.class);
        Properties properties = new Properties();
        properties.setProperty("rocketmq.name-server", "123123");
        PropertiesPropertySource prop = new PropertiesPropertySource("rocketmqProperties", properties);
        env.getPropertySources().addFirst(prop);
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
    }
}
