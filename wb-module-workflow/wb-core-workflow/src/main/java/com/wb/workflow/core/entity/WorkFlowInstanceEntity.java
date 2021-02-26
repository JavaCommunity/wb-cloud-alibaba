package com.wb.workflow.core.entity;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: WorkFlowInstanceEntity
 * @Package: com.wb.workflow.core.entity
 * @Description: the work flow instance entity
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public class WorkFlowInstanceEntity extends BaseEntity {

    //  the definition id
    private String definitionId;

    //  the definition code
    private String definitionCode;

    //  the definition name
    private String definitionName;

    //  the flowable definition id
    private String fDefinitionId;

    //  the flowable instance id
    private String fInstanceId;

    //  the flowable deployment id
    private String fDeploymentId;

    //  the business key
    private String businessKey;

    //  the status
    private String status;

    //  the finish time
    private String finishTime;

    //  the title
    private String title;

    //  the result
    private String result;

    //  the due date
    private String dueDate;

    //  the set json
    private String setJson;

    //  the description
    private String description;

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

    public String getDefinitionName() {
        return definitionName;
    }

    public void setDefinitionName(String definitionName) {
        this.definitionName = definitionName;
    }

    public String getfDefinitionId() {
        return fDefinitionId;
    }

    public void setfDefinitionId(String fDefinitionId) {
        this.fDefinitionId = fDefinitionId;
    }

    public String getfInstanceId() {
        return fInstanceId;
    }

    public void setfInstanceId(String fInstanceId) {
        this.fInstanceId = fInstanceId;
    }

    public String getfDeploymentId() {
        return fDeploymentId;
    }

    public void setfDeploymentId(String fDeploymentId) {
        this.fDeploymentId = fDeploymentId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getSetJson() {
        return setJson;
    }

    public void setSetJson(String setJson) {
        this.setJson = setJson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
