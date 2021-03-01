package com.wb.flowable.ext.api.task;

import org.flowable.task.api.Task;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;

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

    /**
     * create sub task with the specified parent task and assignee user.
     *
     * @param parentTask   the parent task
     * @param assigneeUser the assignee user
     * @return the task entity
     */
    TaskEntity createSubTask(TaskEntity parentTask, String assigneeUser);

    /**
     * chaim task with the specified task id and chaim user id.
     *
     * @param taskId      the task id
     * @param chaimUserId the chaim user id
     */
    void chaimTask(String taskId, String chaimUserId);

    /**
     * un claim task with the specified task id.
     *
     * @param taskId the task id
     */
    void unClaim(String taskId);
}
