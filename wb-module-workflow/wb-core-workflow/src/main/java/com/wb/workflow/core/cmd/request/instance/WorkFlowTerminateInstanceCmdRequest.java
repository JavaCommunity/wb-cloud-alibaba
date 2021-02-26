package com.wb.workflow.core.cmd.request.instance;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;

/**
 * @ClassName: WorkFlowTerminateInstanceCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.instance
 * @Description: the work flow terminate instance cmd request
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public class WorkFlowTerminateInstanceCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    @Override
    public void check() {
        WorkFlowReqCheckUtils.checkEmpty(instanceId, "instanceId");
    }
}
