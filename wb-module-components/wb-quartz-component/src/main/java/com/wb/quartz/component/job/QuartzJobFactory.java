package com.wb.quartz.component.job;

import com.wb.quartz.component.config.QuartzConstant;
import com.wb.quartz.component.vo.QuartzJobVo;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: QuartzJobFactory
 * @Package: com.wb.quartz.component.job
 * @Description: the quartz job factory
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class QuartzJobFactory implements Job {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(QuartzJobFactory.class);

    @Autowired
    private QuartzJobExecute quartzJobExecute;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
            if (CollectionUtils.isEmpty(dataMap)) {
                return;
            }
            Object obj = dataMap.get(QuartzConstant.DEFAULT_JOB_DATA_MAP_KEY);
            if (!ObjectUtils.isEmpty(obj) && obj instanceof QuartzJobVo) {
                quartzJobExecute.before();
                quartzJobExecute.execute((QuartzJobVo) obj, jobExecutionContext);
                quartzJobExecute.after();
            }
        } catch (Exception e) {
            log.error("[Quartz Starter] Job Execute Error,ErrMsg:{}", e.getMessage());
        }
    }
}
