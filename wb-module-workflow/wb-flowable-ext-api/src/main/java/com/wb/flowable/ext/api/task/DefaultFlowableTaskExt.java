package com.wb.flowable.ext.api.task;

import com.wb.flowable.ext.api.idgenerator.FlowableIdGeneratorExt;
import com.wb.flowable.ext.api.utils.FlowableReqCheckUtils;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

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
        FlowableReqCheckUtils.checkEmpty(parentTask, "parentTask");
        FlowableReqCheckUtils.checkEmpty(assigneeUser, "assigneeUser");

        TaskEntity taskEntity = (TaskEntity) taskService.newTask();
        taskEntity.setAssignee(assigneeUser);
        taskEntity.setId(idGeneratorExt.getNextId());
        taskEntity.setCategory(parentTask.getCategory());
        taskEntity.setDescription(parentTask.getDescription());
        taskEntity.setTenantId(parentTask.getTenantId());
        taskEntity.setName(parentTask.getName());
        taskEntity.setParentTaskId(parentTask.getParentTaskId());
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
}
