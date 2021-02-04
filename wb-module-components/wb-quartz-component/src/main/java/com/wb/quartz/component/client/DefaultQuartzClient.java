package com.wb.quartz.component.client;

import com.wb.quartz.component.config.MisfireTypeEnum;
import com.wb.quartz.component.config.QuartzConstant;
import com.wb.quartz.component.exception.QuartzServiceException;
import com.wb.quartz.component.initializer.DefaultQuartzContextInitializer;
import com.wb.quartz.component.job.QuartzJobFactory;
import com.wb.quartz.component.resolver.HandlerJobMisfireResolver;
import com.wb.quartz.component.utils.CronUtils;
import com.wb.quartz.component.vo.QuartzJobVo;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: DefaultQuartzClient
 * @Package: com.wb.quartz.component.client
 * @Description: the default quartz client
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Component
public class DefaultQuartzClient extends DefaultQuartzContextInitializer implements QuartzClient {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DefaultQuartzClient.class);

    @Autowired
    private Scheduler scheduler;

    @Override
    public void create(QuartzJobVo jobVo) throws QuartzServiceException {
        try {
            Assert.notNull(this.scheduler, "'scheduler' must not be null！");
            Assert.notNull(jobVo, "'jobVo' must not be null！");

            //  check the cron expression is valid
            boolean validExpression = CronUtils.isValid(jobVo.getCronExpression());
            Assert.isTrue(validExpression, "cron expression is not valid！");

            Class jobClass = QuartzJobFactory.class;
            //  the instantiates a new job detail
            JobDetail jobDetail = JobBuilder
                    .newJob(jobClass)
                    .withIdentity(getJobKey(jobVo.getCode(), jobVo.getName()))
                    .withDescription(jobVo.getDescription())
                    .build();

            //  the instantiates a  new cron schedule builder
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                    .cronSchedule(jobVo.getCronExpression());

            MisfireTypeEnum misfireType = MisfireTypeEnum.getMisfireType(jobVo.getMisfireType());
            if (ObjectUtils.isEmpty(misfireType)) {
                misfireType = QuartzConstant.DEFAULT_MISFIRE_TYPE;
            }
            HandlerJobMisfireResolver handlerJobMisfireResolver = super.getHandlerJobMisfireResolver(misfireType);
            Assert.notNull(handlerJobMisfireResolver, "'handlerJobMisfireResolver' must not null！");
            handlerJobMisfireResolver.handleJobMisfire(scheduleBuilder);

            //  the instantiates  a new cron trigger
            CronTrigger cronTrigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(getTriggerKey(jobVo.getCode(), jobVo.getTriggerGroup()))
                    .withDescription(jobVo.getDescription())
                    .withSchedule(scheduleBuilder)
                    .startNow()
                    .build();
            jobDetail.getJobDataMap().put(QuartzConstant.DEFAULT_JOB_DATA_MAP_KEY, jobVo);
            this.scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (Exception e) {
            log.error("[Quartz Starter] Create Job Error,ErrMsg:{}", e.getMessage());
            throw new QuartzServiceException(e.getMessage());
        }
    }

    @Override
    public void update(QuartzJobVo jobVo) throws QuartzServiceException {
        try {
            Assert.notNull(scheduler, "'scheduler' must not be null！");
            Assert.notNull(jobVo, "'jobVo' must not be null！");

            delete(jobVo);
            create(jobVo);
        } catch (Exception e) {
            log.error("[Quartz Starter] Update Job Error,ErrMsg:{}", e.getMessage());
            throw new QuartzServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(QuartzJobVo jobVo) throws QuartzServiceException {
        try {
            Assert.notNull(scheduler, "'scheduler' must not be null！");
            Assert.notNull(jobVo, "'jobVo' must not be null！");

            scheduler.deleteJob(getJobKey(jobVo.getCode(), jobVo.getGroup()));
        } catch (Exception e) {
            log.error("[Quartz Starter] Delete Job Error,ErrMsg:{}", e.getMessage());
            throw new QuartzServiceException(e.getMessage());
        }
    }

    @Override
    public void suspend(QuartzJobVo jobVo) throws QuartzServiceException {
        try {
            Assert.notNull(scheduler, "'scheduler' must not be null！");
            Assert.notNull(jobVo, "'jobVo' must not be null！");

            scheduler.pauseJob(getJobKey(jobVo.getCode(), jobVo.getGroup()));
        } catch (Exception e) {
            log.error("[Quartz Starter] Suspend Job Error,ErrMsg:{}", e.getMessage());
            throw new QuartzServiceException(e.getMessage());
        }
    }

    @Override
    public void active(QuartzJobVo jobVo) throws QuartzServiceException {
        try {
            Assert.notNull(scheduler, "'scheduler' must not be null！");
            Assert.notNull(jobVo, "'jobVo' must not be null！");

            scheduler.resumeJob(getJobKey(jobVo.getCode(), jobVo.getGroup()));
        } catch (Exception e) {
            log.error("[Quartz Starter] Active Job Error,ErrMsg:{}", e.getMessage());
            throw new QuartzServiceException(e.getMessage());
        }
    }

    @Override
    public void execute(QuartzJobVo jobVo) throws QuartzServiceException {
        try {
            Assert.notNull(scheduler, "'scheduler' must not null！");
            Assert.notNull(jobVo, "'jobVo' must not null！");

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put(QuartzConstant.DEFAULT_JOB_DATA_MAP_KEY, jobVo.getData());
            scheduler.triggerJob(getJobKey(jobVo.getCode(), jobVo.getGroup()), jobDataMap);
        } catch (Exception e) {
            log.error("[Quartz Starter] Execute Job Error,ErrMsg:{}", e.getMessage());
            throw new QuartzServiceException(e.getMessage());
        }
    }

    /**
     * get job key with the specified code and name
     *
     * @param code the code
     * @param name the name
     * @return the job key
     */
    private JobKey getJobKey(String code, String name) {
        Assert.hasLength(code, "'code' must not be null！");
        Assert.hasLength(name, "'name' must not be null！");

        return JobKey.jobKey(QuartzConstant.DEFAULT_JON_KEY_PREFIX + code, name);
    }

    /**
     * get trigger key with the specified code and group
     *
     * @param code  the code
     * @param group the group
     * @return the trigger key
     */
    private TriggerKey getTriggerKey(String code, String group) {
        Assert.hasLength(code, "'code' must not be null！");
        Assert.hasLength(group, "'group' must not be null！");

        return TriggerKey.triggerKey(QuartzConstant.DEFAULT_TRIGGER_KEY_PREFIX + code, group);
    }
}
