package com.wb.workflow.core.entity;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: WorkFlowTaskOperationEntity
 * @Package: com.wb.workflow.core.entity
 * @Description: the work flow operation entity
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
public class WorkFlowTaskOperationEntity extends BaseEntity {

    //  the process instance id
    private String instanceId;

    //  the task id
    private String taskId;

    //  the task key
    private String taskKey;

    //  the task name
    private String taskName;

    //  the approver id
    private String approverId;

    //  the approver name
    private String approverName;

    //  the approve result
    private String approveResult;

    //  the approve type
    private String approveType;

    //  the approve opinion
    private String approveOpinion;

    //  the due date
    private String dueDate;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    public String getApproveOpinion() {
        return approveOpinion;
    }

    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
