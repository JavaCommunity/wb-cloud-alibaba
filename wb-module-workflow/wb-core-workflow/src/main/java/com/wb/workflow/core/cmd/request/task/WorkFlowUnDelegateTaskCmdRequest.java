package com.wb.workflow.core.cmd.request.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;

import java.util.Map;

/**
 * @ClassName: WorkFlowUnDelegateTaskCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.task
 * @Description: the work flow un delegate task cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowUnDelegateTaskCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    //  the variables
    private Map<String, Object> variables;

    @Override
    public void check() {
        WorkFlowReqCheckUtils.checkEmpty(taskId, "taskId");
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
