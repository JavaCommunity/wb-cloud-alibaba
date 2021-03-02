package com.wb.workflow.core.cmd.task;

import com.wb.flowable.ext.api.task.FlowableTaskExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.task.WorkFlowUnClaimTaskCmdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowUnClaimTaskCmd
 * @Package: com.wb.workflow.core.cmd.task
 * @Description: the work flow un chaim task cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowUnClaimTaskCmd extends AbstractWorkFlowTaskCmd {

    @Autowired
    private FlowableTaskExt taskExt;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        taskExt.unClaim(cmdRequest.getTaskId());
        return null;
    }

    @Override
    public void after(WorkFlowGenericCmdRequest cmdRequest) {
        super.addTaskOperation(cmdRequest);
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowUnClaimTaskCmdRequest.class;
    }
}
