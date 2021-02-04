package com.wb.quartz.component.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: QuartzDisallowConcurrentExecution
 * @Package: com.wb.quartz.component.job
 * @Description: the quartz disallow concurrent execution
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution implements Job {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(QuartzDisallowConcurrentExecution.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            //  TODO 暂时不写实现
        } catch (Exception e) {
            log.error("[Quartz Starter] Job Execute Error,ErrMsg:{}", e.getMessage());
        }
    }
}
