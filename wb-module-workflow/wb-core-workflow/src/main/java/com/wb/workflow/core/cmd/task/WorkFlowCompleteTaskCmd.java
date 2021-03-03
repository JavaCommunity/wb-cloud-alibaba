package com.wb.workflow.core.cmd.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowCompleteTaskCmdRequest;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import org.flowable.engine.TaskService;
import org.flowable.task.api.DelegationState;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @ClassName: WorkFlowCompleteTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow complete task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowCompleteTaskCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private TaskService taskService;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowCompleteTaskCmdRequest request = (WorkFlowCompleteTaskCmdRequest) cmdRequest;
        String userId = request.getUserId();
        if (StringUtils.isEmpty(userId)) {
            userId = WorkFlowContextHolder.getCurrentUserId();
        }
        Task task = request.getTask();
        String taskId = request.getTaskId();
        if (task.getAssignee() == null || !task.getAssignee().equals(userId)) {
            taskService.setAssignee(taskId, userId);
        }
        Map<String, Object> variables = request.getVariables();
        if (DelegationState.PENDING.equals(task.getDelegationState())) {
            taskService.resolveTask(taskId, variables);
            if (userId.equals(task.getOwner())) {
                taskService.complete(taskId, variables);
            }
        }
        taskService.complete(taskId, variables);
        return null;
    }

    @Override
    public void after(WorkFlowGenericCmdRequest cmdRequest) {
        super.addTaskOperation(cmdRequest);
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowCompleteTaskCmdRequest.class;
    }
}
