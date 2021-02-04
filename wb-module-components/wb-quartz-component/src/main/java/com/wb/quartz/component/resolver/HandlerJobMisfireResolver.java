package com.wb.quartz.component.resolver;

import com.wb.quartz.component.config.MisfireTypeEnum;
import com.wb.quartz.component.exception.QuartzServiceException;
import org.quartz.CronScheduleBuilder;

/**
 * @ClassName: HandlerJobMisfireResolver
 * @Package: com.wb.quartz.component.resolver
 * @Description: the handler job misfire resolver
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public interface HandlerJobMisfireResolver {

    /**
     * is support misfire with the specified misfire type
     *
     * @param misfireType the misfire type
     * @return <tt>true</> if the support misfire type
     * @throws QuartzServiceException
     */
    boolean supportMisfire(MisfireTypeEnum misfireType) throws QuartzServiceException;

    /**
     * handler job misfire with the specified cron schedule builder
     *
     * @param cronScheduleBuilder the cron schedule builder
     * @throws QuartzServiceException
     */
    void handleJobMisfire(CronScheduleBuilder cronScheduleBuilder) throws QuartzServiceException;
}
