package com.wb.flowable.ext.api.task;

import org.flowable.task.api.Task;

/**
 * @ClassName: FlowableTaskExt
 * @Package: com.wb.flowable.ext.api.task
 * @Description: the flowable task ext
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public interface FlowableTaskExt {

    /**
     * query task with the specified task id
     *
     * @param taskId the task id
     * @return the task
     */
    Task queryForId(String taskId);
}
