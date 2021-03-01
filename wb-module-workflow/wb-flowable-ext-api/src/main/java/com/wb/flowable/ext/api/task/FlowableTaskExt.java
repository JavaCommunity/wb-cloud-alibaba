package com.wb.flowable.ext.api.task;

import com.wb.flowable.ext.api.config.FlowableAppendSignEnum;
import org.flowable.task.api.Task;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;

import java.util.List;
import java.util.Map;

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
     * create sub task with the specified parent task and parent task
     * id and assignee user.
     *
     * @param parentTask   the parent task
     * @param parentTaskId the parent task id
     * @param assigneeUser the assignee user
     * @return the task entity
     */
    TaskEntity createSubTask(TaskEntity parentTask, String parentTaskId, String assigneeUser);

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

    /**
     * append sign with the specified user id and task
     * and by append sign user and append sign.
     *
     * @param userId           the task id
     * @param task             the task
     * @param byAppendSignUser the by append sign user
     * @param appendSign       the append sign
     */
    void appendSign(String userId, Task task, List<String> byAppendSignUser, FlowableAppendSignEnum appendSign);

    /**
     * delegate task with the specified task id and
     * delegate user id.
     *
     * @param taskId         the user id
     * @param delegateUserId the delegate user id
     */
    void delegate(String taskId, String delegateUserId);

    /**
     * un delegate task with the specified task id and var.
     *
     * @param taskId the task id
     * @param var    the var
     */
    void unDelegate(String taskId, Map<String, Object> var);
}
