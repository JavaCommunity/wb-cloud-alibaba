package com.wb.quartz.component.resolver;

import com.wb.quartz.component.config.MisfireTypeEnum;
import com.wb.quartz.component.exception.QuartzServiceException;
import org.quartz.CronScheduleBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @ClassName: FireAndProceedJobMisfireResolver
 * @Package: com.wb.quartz.component.resolver
 * @Description: the fire and proceed job misfire resolver
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Component
public class FireAndProceedJobMisfireResolver implements HandlerJobMisfireResolver {

    @Override
    public boolean supportMisfire(MisfireTypeEnum misfireType) throws QuartzServiceException {
        if (MisfireTypeEnum.FIRE_AND_PROCEED.equals(misfireType)) {
            return true;
        }
        return false;
    }

    @Override
    public void handleJobMisfire(CronScheduleBuilder cronScheduleBuilder) throws QuartzServiceException {
        try {
            Assert.notNull(cronScheduleBuilder, "'cronScheduleBuilder' must not null！");

            cronScheduleBuilder.withMisfireHandlingInstructionFireAndProceed();
        } catch (Exception e) {
            throw new QuartzServiceException(e.getMessage());
        }
    }
}
