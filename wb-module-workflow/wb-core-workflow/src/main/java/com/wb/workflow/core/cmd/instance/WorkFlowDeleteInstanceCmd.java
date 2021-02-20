package com.wb.workflow.core.cmd.instance;

import com.wb.flowable.ext.api.instance.FlowableInstanceExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.instance.WorkFlowDeleteInstanceCmdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowDeleteInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the delete instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowDeleteInstanceCmd extends AbstractWorkFlowInstanceCmd {

    @Autowired
    private FlowableInstanceExt instanceExt;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowDeleteInstanceCmdRequest request = (WorkFlowDeleteInstanceCmdRequest) cmdRequest;

        String instanceId = request.getInstanceId();
        instanceExt.checkForId(instanceId);
        instanceExt.delete(instanceId, request.getDeleteReason(), request.isCascade());
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowDeleteInstanceCmdRequest.class;
    }
}
