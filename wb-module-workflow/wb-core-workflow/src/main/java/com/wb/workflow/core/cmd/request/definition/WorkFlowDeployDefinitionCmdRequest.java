package com.wb.workflow.core.cmd.request.definition;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;

/**
 * @ClassName: WorkFlowDeployDefinitionCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.definition
 * @Description: the work flow deployment definition cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowDeployDefinitionCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    @Override
    public void check() {
        WorkFlowReqCheckUtils.checkEmpty(definitionId, "definitionId");
    }
}
