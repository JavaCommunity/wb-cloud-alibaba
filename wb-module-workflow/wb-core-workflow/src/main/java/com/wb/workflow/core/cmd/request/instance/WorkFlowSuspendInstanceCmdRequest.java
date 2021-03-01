package com.wb.workflow.core.cmd.request.instance;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;

/**
 * @ClassName: WorkFlowSuspendInstanceCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.instance
 * @Description: the work flow suspend instance cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowSuspendInstanceCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    @Override
    public void check() {
        WorkFlowReqCheckUtils.checkEmpty(instanceId, "instanceId");
    }
}
