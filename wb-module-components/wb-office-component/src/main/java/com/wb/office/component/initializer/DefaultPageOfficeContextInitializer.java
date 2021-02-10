package com.wb.office.component.initializer;

import com.wb.office.component.handler.PageOfficeHandler;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DefaultPageOfficeContextInitializer
 * @Package: com.wb.office.component.initializer
 * @Description: the default pageOffice context initializer
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
@Component
public class DefaultPageOfficeContextInitializer implements PageOfficeContextInitializer {

    //  the pageOffice load handlers
    public Map<String, PageOfficeHandler> pageOfficeLoadHandlers;

    //  the detect all pageOffice load handler
    public boolean detectAllPageOfficeLoadHandler = true;

    @Override
    public void onRefresh(ContextRefreshedEvent event) {
        initStrategies(event.getApplicationContext());
    }

    @Override
    public void initStrategies(ApplicationContext context) {
        this.initPageOfficeLoadHandlers(context);
    }

    @Override
    public Map<String, PageOfficeHandler> getLoadHandlers() {
        return this.pageOfficeLoadHandlers;
    }

    /**
     * init pageOffice load handlers with the specified application context
     *
     * @param context the application context
     */
    private void initPageOfficeLoadHandlers(ApplicationContext context) {
        this.pageOfficeLoadHandlers = null;
        if (this.detectAllPageOfficeLoadHandler) {
            Map<String, PageOfficeHandler> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors
                    (context, PageOfficeHandler.class, true, false);
            if (matchingBeans.isEmpty()) {
                pageOfficeLoadHandlers = new HashMap<>();
                return;
            }

            pageOfficeLoadHandlers = new HashMap<>(matchingBeans.size());
            matchingBeans.entrySet().stream().forEach((entry) -> {
                com.wb.office.component.annotation.PageOfficeHandler officeHandler = entry.getValue().getClass().getAnnotation(com.wb.office.component.annotation.PageOfficeHandler.class);
                if (StringUtils.isEmpty(officeHandler.value())) {
                    pageOfficeLoadHandlers.put(entry.getKey(), entry.getValue());
                } else {
                    pageOfficeLoadHandlers.put(officeHandler.value(), entry.getValue());
                }
            });
        }
    }

    public void setDetectAllPageOfficeLoadHandler(boolean detectAllPageOfficeLoadHandler) {
        this.detectAllPageOfficeLoadHandler = detectAllPageOfficeLoadHandler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.onRefresh(event);
    }
}
