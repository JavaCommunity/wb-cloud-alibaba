package com.wb.workflow.core.cmd.request.instance;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

import java.util.Map;

/**
 * @ClassName: WorkFlowStartInstanceCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.instance
 * @Description: the work flow start instance cmd request
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public class WorkFlowStartInstanceCmdRequest extends WorkFlowGenericCmdRequest<String> {

    //  the business key
    private String businessKey;

    //  the variables
    private Map<String, Object> variables;

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
