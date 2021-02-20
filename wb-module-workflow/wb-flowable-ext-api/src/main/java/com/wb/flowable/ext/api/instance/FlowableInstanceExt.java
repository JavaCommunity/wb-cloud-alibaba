package com.wb.flowable.ext.api.instance;

import org.flowable.engine.runtime.ProcessInstance;

/**
 * @ClassName: FlowableInstanceExt
 * @Package: com.wb.flowable.ext.api.instance
 * @Description: the flowable instance ext
 * @Author：[bo.wang]
 * @Date: 2021/2/20
 * @Version: 1.0
 */
public interface FlowableInstanceExt {

    /**
     * check process instance info with the specified process instance id.
     *
     * @param processInstanceId the process instance id
     */
    void checkForId(String processInstanceId);

    /**
     * query process instance info with the specified process instance id.
     *
     * @param processInstanceId the process instance id
     * @return the process instance info
     */
    ProcessInstance queryForId(String processInstanceId);

    /**
     * the delete process instance info with the specified process instance id and delete reason and cascade.
     *
     * @param processInstanceId the process instance id
     * @param deleteReason      the delete reason
     * @param cascade           the cascade
     */
    void delete(String processInstanceId, String deleteReason, boolean cascade);
}
