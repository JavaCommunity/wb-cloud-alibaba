package com.wb.quartz.component.client;

import com.wb.quartz.component.exception.QuartzServiceException;
import com.wb.quartz.component.vo.QuartzJobVo;

/**
 * @ClassName: QuartzClient
 * @Package: com.wb.quartz.component.client
 * @Description: the quartz client
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public interface QuartzClient {

    /**
     * the create job
     *
     * @param jobVo the job vo
     * @throws QuartzServiceException
     */
    void create(QuartzJobVo jobVo) throws QuartzServiceException;

    /**
     * the update job
     *
     * @param jobVo the job vo
     * @throws QuartzServiceException
     */
    void update(QuartzJobVo jobVo) throws QuartzServiceException;

    /**
     * the delete job
     *
     * @param jobVo the job vo
     * @throws QuartzServiceException
     */
    void delete(QuartzJobVo jobVo) throws QuartzServiceException;

    /**
     * the suspend job
     *
     * @param jobVo the job vo
     * @throws QuartzServiceException
     */
    void suspend(QuartzJobVo jobVo) throws QuartzServiceException;

    /**
     * the active job
     *
     * @param jobVo the job vo
     * @throws QuartzServiceException
     */
    void active(QuartzJobVo jobVo) throws QuartzServiceException;

    /**
     * the execute job
     *
     * @param jobVo the job vo
     * @throws QuartzServiceException
     */
    void execute(QuartzJobVo jobVo) throws QuartzServiceException;
}
