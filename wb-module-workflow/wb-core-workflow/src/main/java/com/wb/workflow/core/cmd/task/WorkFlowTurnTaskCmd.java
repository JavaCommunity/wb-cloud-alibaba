package com.wb.workflow.core.cmd.task;

import com.wb.flowable.ext.api.task.FlowableTaskExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowTurnTaskCmdRequest;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowTurnTaskCmdRequest request = (WorkFlowTurnTaskCmdRequest) cmdRequest;

        String taskId = request.getTaskId();
        String turnUserId = request.getTurnUserId();
        taskService.setAssignee(taskId, turnUserId);
        return null;
    }

    @Override
    public void after(WorkFlowGenericCmdRequest cmdRequest) {
        super.addTaskOperation(cmdRequest);
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowTurnTaskCmdRequest.class;
    }
}
