package com.wb.workflow.core.cmd.request;

/**
 * @ClassName: AbstractWorkFlowCmdRequest
 * @Package: com.wb.workflow.core.cmd.request
 * @Description: the work flow generic cmd request
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public abstract class WorkFlowGenericCmdRequest<T> implements WorkFlowCmdRequest<T> {

    //  the workFlow definition id
    protected String definitionId;

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }
}
