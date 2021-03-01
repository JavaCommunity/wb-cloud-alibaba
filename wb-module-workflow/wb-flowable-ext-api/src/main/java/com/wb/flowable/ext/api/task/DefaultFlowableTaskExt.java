package com.wb.flowable.ext.api.task;

import com.wb.flowable.ext.api.config.FlowableAppendSignEnum;
import com.wb.flowable.ext.api.idgenerator.FlowableIdGeneratorExt;
import com.wb.flowable.ext.api.utils.FlowableReqCheckUtils;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DefaultFlowableTaskExt
 * @Package: com.wb.flowable.ext.api.task
 * @Description: the default flowable task ext
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class DefaultFlowableTaskExt implements FlowableTaskExt {

    @Autowired
    private TaskService taskService;

    @Autowired
    private FlowableIdGeneratorExt idGeneratorExt;

    @Override
    public Task queryForId(String taskId) {
        FlowableReqCheckUtils.checkEmpty(taskId, "taskId");

        return taskService
                .createTaskQuery()
                .taskId(taskId)
                .singleResult();
    }

    @Override
    public TaskEntity createSubTask(TaskEntity parentTask, String assigneeUser) {
        return createSubTask(parentTask, parentTask.getParentTaskId(), assigneeUser);
    }

    @Override
    public TaskEntity createSubTask(TaskEntity parentTask, String parentTaskId, String assigneeUser) {
        FlowableReqCheckUtils.checkEmpty(parentTask, "parentTask");
        FlowableReqCheckUtils.checkEmpty(assigneeUser, "assigneeUser");
        FlowableReqCheckUtils.checkEmpty(parentTaskId, "parentTaskId");

        TaskEntity taskEntity = (TaskEntity) taskService.newTask();
        taskEntity.setAssignee(assigneeUser);
        taskEntity.setId(idGeneratorExt.getNextId());
        taskEntity.setCategory(parentTask.getCategory());
        taskEntity.setDescription(parentTask.getDescription());
        taskEntity.setTenantId(parentTask.getTenantId());
        taskEntity.setName(parentTask.getName());
        taskEntity.setParentTaskId(parentTaskId);
        taskEntity.setProcessDefinitionId(parentTask.getProcessDefinitionId());
        taskEntity.setProcessInstanceId(parentTask.getProcessInstanceId());
        taskEntity.setTaskDefinitionKey(parentTask.getTaskDefinitionKey());
        taskEntity.setTaskDefinitionId(parentTask.getTaskDefinitionId());
        taskEntity.setPriority(parentTask.getPriority());
        taskEntity.setCreateTime(new Date());
        taskService.saveTask(taskEntity);
        return taskEntity;
    }

    @Override
    public void chaimTask(String taskId, String chaimUserId) {
        FlowableReqCheckUtils.checkEmpty(taskId, "taskId");
        FlowableReqCheckUtils.checkEmpty(chaimUserId, "chaimUserId");

        taskService.claim(taskId, chaimUserId);
    }

    @Override
    public void unClaim(String taskId) {
        FlowableReqCheckUtils.checkEmpty(taskId, "taskId");

        taskService.unclaim(taskId);
    }

    @Override
    public void appendSign(String userId, Task task, List<String> byAppendSignUser, FlowableAppendSignEnum appendSign) {
        FlowableReqCheckUtils.checkEmpty(userId, "userId");
        FlowableReqCheckUtils.checkEmpty(task, "task");
        FlowableReqCheckUtils.checkEmpty(byAppendSignUser, "byAppendSignUser");

        TaskEntityImpl taskEntity = (TaskEntityImpl) task;
        //  the handle loop append sign
        handleLoopAppendSign(taskEntity, userId, appendSign);

        //  the create append sign task
        createAppendSignTask(taskEntity, byAppendSignUser);

        //  the handle append sign user task
        handleAppendSignUserTask(taskEntity, userId);
    }

    @Override
    public void delegate(String taskId, String delegateUserId) {
        FlowableReqCheckUtils.checkEmpty(taskId, "taskId");
        FlowableReqCheckUtils.checkEmpty(delegateUserId, "delegateUserId");

        taskService.delegateTask(taskId, delegateUserId);
    }

    @Override
    public void unDelegate(String taskId, Map<String, Object> var) {
        FlowableReqCheckUtils.checkEmpty(taskId, "taskId");

        taskService.resolveTask(taskId, var);
    }

    /**
     * handle loop append sign with the specified task entity
     * and user id and append sign.
     *
     * @param taskEntity the task entity
     * @param userId     the user id
     * @param appendSign the append sign
     */
    private void handleLoopAppendSign(TaskEntityImpl taskEntity, String userId, FlowableAppendSignEnum appendSign) {
        if (StringUtils.isEmpty(taskEntity.getParentTaskId())) {
            taskEntity.setOwner(userId);
            taskEntity.setAssignee(null);
            taskEntity.setCountEnabled(true);
            taskEntity.setScopeType(appendSign.name());
            taskService.saveTask(taskEntity);
        }
    }

    /**
     * create append sign task with the specified task entity
     * and by append sign user.
     *
     * @param taskEntity       the task entity
     * @param byAppendSignUser the by append sign user
     */
    private void createAppendSignTask(TaskEntity taskEntity, List<String> byAppendSignUser) {
        String parentTaskId = taskEntity.getParentTaskId();
        if (StringUtils.isEmpty(parentTaskId)) {
            parentTaskId = taskEntity.getId();
        }
        final String finalParentTaskId = parentTaskId;
        byAppendSignUser.stream().forEach((var1) -> {
            createSubTask(taskEntity, finalParentTaskId, var1);
        });
    }

    /**
     * handle append sign user task with the specified task entity
     * and user id
     *
     * @param taskEntity the task entity
     * @param userId     the user id
     */
    private void handleAppendSignUserTask(TaskEntity taskEntity, String userId) {
        String parentTaskId = taskEntity.getParentTaskId();
        String taskId = taskEntity.getId();
        if (StringUtils.isEmpty(parentTaskId)) {
            parentTaskId = taskEntity.getId();
            Task task = this.createSubTask(taskEntity, parentTaskId, userId);
            taskId = task.getId();
        }
        TaskEntity appendSignUserTask = (TaskEntity) queryForId(taskId);
        if (!ObjectUtils.isEmpty(appendSignUserTask)) {
            taskService.complete(taskId);
        }
        long candidateCount = taskService.createTaskQuery().taskId(parentTaskId).taskCandidateUser(userId).count();
        if (candidateCount > 0) {
            taskService.deleteCandidateUser(parentTaskId, userId);
        }
    }
}
