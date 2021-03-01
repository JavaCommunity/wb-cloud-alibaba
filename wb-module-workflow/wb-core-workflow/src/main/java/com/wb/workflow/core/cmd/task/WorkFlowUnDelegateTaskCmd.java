package com.wb.workflow.core.cmd.task;

import com.wb.flowable.ext.api.task.FlowableTaskExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowUnDelegateTaskCmdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowUnDelegateTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow un delegate task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowUnDelegateTaskCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private FlowableTaskExt taskExt;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowUnDelegateTaskCmdRequest request = (WorkFlowUnDelegateTaskCmdRequest) cmdRequest;
        taskExt.unDelegate(request.getTaskId(), request.getVariables());
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowUnDelegateTaskCmdRequest.class;
    }
}
