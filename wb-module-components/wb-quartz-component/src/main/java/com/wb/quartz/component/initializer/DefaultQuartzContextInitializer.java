package com.wb.quartz.component.initializer;

import com.wb.quartz.component.config.MisfireTypeEnum;
import com.wb.quartz.component.resolver.HandlerJobMisfireResolver;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @ClassName: DefaultQuartzContextInitializer
 * @Package: com.wb.quartz.component.initializer
 * @Description: the default quartz context initializer
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Component
public class DefaultQuartzContextInitializer implements QuartzContextInitializer, ApplicationListener<ContextRefreshedEvent> {

    //  the job misfire resolvers
    public List<HandlerJobMisfireResolver> jobMisfireResolvers;

    //  the detect all job misfire resolvers
    public boolean detectAllJobMisfireResolvers = true;

    //  the active
    private boolean active = false;

    @Override
    public void onRefresh(ContextRefreshedEvent event) {
        if (!active) {
            this.initStrategies(event.getApplicationContext());
        }
    }

    @Override
    public void initStrategies(ApplicationContext context) {
        this.initHandlerJobMisfireResolver(context);
    }

    /**
     * the init handler job misfire resolver
     *
     * @param context the application context
     */
    private void initHandlerJobMisfireResolver(ApplicationContext context) {
        this.jobMisfireResolvers = null;
        if (this.detectAllJobMisfireResolvers) {
            Map<String, HandlerJobMisfireResolver> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors
                    (context, HandlerJobMisfireResolver.class, true, false);
            if (!matchingBeans.isEmpty()) {
                this.jobMisfireResolvers = new ArrayList(matchingBeans.values());
                AnnotationAwareOrderComparator.sort(this.jobMisfireResolvers);
            } else {
                HandlerJobMisfireResolver handlerInternalMethodInvokeResolver = (HandlerJobMisfireResolver)
                        context.getBean("handlerInternalMethodInvokeResolver", HandlerJobMisfireResolver.class);
                this.jobMisfireResolvers = Collections.singletonList(handlerInternalMethodInvokeResolver);
            }
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.onRefresh(event);
    }

    /**
     * the get handler job misfire resolver
     *
     * @param misfireType the misfire type
     * @return the handler job misfire resolver
     */
    public HandlerJobMisfireResolver getHandlerJobMisfireResolver(MisfireTypeEnum misfireType) {
        Assert.notNull(misfireType, "'misfireType' must not null！");

        if (jobMisfireResolvers != null) {
            Iterator<HandlerJobMisfireResolver> iterator = jobMisfireResolvers.iterator();
            while (iterator.hasNext()) {
                HandlerJobMisfireResolver jobMisfireResolver = iterator.next();
                if (jobMisfireResolver.supportMisfire(misfireType)) {
                    return jobMisfireResolver;
                }
            }
        }
        return null;
    }

    public boolean isDetectAllJobMisfireResolvers() {
        return detectAllJobMisfireResolvers;
    }

    public void setDetectAllJobMisfireResolvers(boolean detectAllJobMisfireResolvers) {
        this.detectAllJobMisfireResolvers = detectAllJobMisfireResolvers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
