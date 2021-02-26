package com.wb.workflow.core.cmd.request;

import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.entity.WorkFlowInstanceEntity;

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

    //  the workFlow instance id
    protected String instanceId;

    //  the work flow instance entity
    protected WorkFlowInstanceEntity instance;

    //  the work flow definition entity
    protected WorkFlowDefinitionEntity definition;

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public WorkFlowInstanceEntity getInstance() {
        return instance;
    }

    public void setInstance(WorkFlowInstanceEntity instance) {
        this.instance = instance;
    }

    public WorkFlowDefinitionEntity getDefinition() {
        return definition;
    }

    public void setDefinition(WorkFlowDefinitionEntity definition) {
        this.definition = definition;
    }
}
