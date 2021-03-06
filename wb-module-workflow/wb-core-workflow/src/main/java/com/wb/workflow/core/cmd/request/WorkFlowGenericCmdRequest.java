package com.wb.workflow.core.cmd.request;

import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import org.flowable.task.api.Task;

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

    //  the workFlow definition code
    protected String definitionCode;

    //  the workFlow instance id
    protected String instanceId;

    //  the work flow instance entity
    protected WorkFlowInstanceEntity instance;

    //  the work flow definition entity
    protected WorkFlowDefinitionEntity definition;

    //  the task id
    protected String taskId;

    //  the task
    protected Task task;

    //  the approve opinion
    protected String approveOpinion;

    //  the cmd type
    protected String cmdType;

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }

    public String getDefinitionCode() {
        return definitionCode;
    }

    public void setDefinitionCode(String definitionCode) {
        this.definitionCode = definitionCode;
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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getApproveOpinion() {
        return approveOpinion;
    }

    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
    }

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }
}
