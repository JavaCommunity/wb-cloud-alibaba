package com.wb.workflow.core.cmd.task;

import com.wb.flowable.ext.api.task.FlowableTaskExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowDelegateTaskCmdRequest;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.exception.WorkFlowException;
import org.flowable.task.api.DelegationState;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowDelegateTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow delegate task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowDelegateTaskCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private FlowableTaskExt taskExt;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowDelegateTaskCmdRequest request = (WorkFlowDelegateTaskCmdRequest) cmdRequest;
        Task task = request.getTask();
        if (!DelegationState.PENDING.equals(task.getDelegationState())) {
            throw new WorkFlowException(WorkFlowErrorEnum.NO_DELEGATE_TASK.getMsg());
        }

        taskExt.delegate(request.getTaskId(), request.getDelegateUserId());
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowDelegateTaskCmdRequest.class;
    }
}
