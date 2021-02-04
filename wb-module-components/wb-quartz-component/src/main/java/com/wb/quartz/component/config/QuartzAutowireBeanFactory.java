package com.wb.quartz.component.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * @ClassName: QuartzAutowireBeanFactory
 * @Package: com.wb.quartz.component.client
 * @Description: the quartz autowire bean factory
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class QuartzAutowireBeanFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    //  the spring bean factory
    private AutowireCapableBeanFactory beanFactory = null;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        beanFactory = applicationContext.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
