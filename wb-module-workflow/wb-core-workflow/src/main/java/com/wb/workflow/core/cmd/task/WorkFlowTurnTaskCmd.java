package com.wb.workflow.core.cmd.task;

import com.wb.flowable.ext.api.task.FlowableTaskExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowTurnTaskCmdRequest;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.exception.WorkFlowException;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: WorkFlowTurnTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow turn task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowTurnTaskCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private TaskService taskService;

    @Autowired
    private FlowableTaskExt taskExt;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowTurnTaskCmdRequest request = (WorkFlowTurnTaskCmdRequest) cmdRequest;

        Task task = request.getTask();
        String taskId = request.getTaskId();
        String turnUserId = request.getTurnUserId();
        //  create sub task entity
        TaskEntity subTaskEntity = taskExt.createSubTask((TaskEntity) task, turnUserId);
        if (ObjectUtils.isEmpty(subTaskEntity)) {
            throw new WorkFlowException(WorkFlowErrorEnum.CREATE_SUB_TASK.getMsg());
        }
        taskService.complete(subTaskEntity.getId());

        taskService.setAssignee(taskId, turnUserId);
        taskService.setOwner(taskId, turnUserId);
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowTurnTaskCmdRequest.class;
    }
}
