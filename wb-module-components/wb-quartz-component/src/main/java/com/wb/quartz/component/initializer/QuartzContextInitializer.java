package com.wb.quartz.component.initializer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @ClassName: DefaultQuartzContextInitializer
 * @Package: com.wb.quartz.component.initializer
 * @Description: the quartz context initializer
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public interface QuartzContextInitializer {

    /**
     * the on refresh context
     *
     * @param event the context refreshed event
     */
    void onRefresh(ContextRefreshedEvent event);

    /**
     * the init strategies
     *
     * @param context the application context
     */
    void initStrategies(ApplicationContext context);
}
