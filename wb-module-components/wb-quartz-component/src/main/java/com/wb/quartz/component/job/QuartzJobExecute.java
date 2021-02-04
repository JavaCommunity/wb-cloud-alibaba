package com.wb.quartz.component.job;

import com.wb.quartz.component.exception.QuartzServiceException;
import com.wb.quartz.component.vo.QuartzJobVo;
import org.quartz.JobExecutionContext;

/**
 * @ClassName: QuartzJobExecute
 * @Package: com.wb.quartz.component.job
 * @Description: the quartz job execute
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public interface QuartzJobExecute {

    /**
     * the job execute before
     *
     * @throws QuartzServiceException
     */
    default void before() throws QuartzServiceException {

    }

    /**
     * the execute job
     *
     * @param jobVo               the job vo
     * @param jobExecutionContext the job execute context
     * @throws QuartzServiceException
     */
    void execute(QuartzJobVo jobVo, JobExecutionContext jobExecutionContext) throws QuartzServiceException;

    /**
     * the job after
     *
     * @throws QuartzServiceException
     */
    default void after() throws QuartzServiceException {

    }
}
