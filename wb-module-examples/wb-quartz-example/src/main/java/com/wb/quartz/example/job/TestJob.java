package com.wb.quartz.example.job;

import com.wb.quartz.component.job.QuartzJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TestJob
 * @Package: com.wb.quartz.example.job
 * @Description: the test job
 * @Author：[bo.wang]
 * @Date: 2021/2/3
 * @Version: 1.0
 */
@Component
public class TestJob implements QuartzJob {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("the test job execute...");
    }
}
