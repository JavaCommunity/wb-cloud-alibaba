package com.wb.office.component.initializer;

import com.wb.office.component.handler.PageOfficeHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * @ClassName: PageOfficeContextInitializer
 * @Package: com.wb.office.component.initializer
 * @Description: the pageOffice context initializer
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
public interface PageOfficeContextInitializer extends ApplicationListener<ContextRefreshedEvent> {

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

    /**
     * get pageOffice load handler
     *
     * @return the pageOffice load handles
     */
    Map<String, PageOfficeHandler> getLoadHandlers();
}
