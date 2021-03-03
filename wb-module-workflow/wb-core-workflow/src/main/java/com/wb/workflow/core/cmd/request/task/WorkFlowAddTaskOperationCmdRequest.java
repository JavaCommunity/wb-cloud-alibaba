package com.wb.workflow.core.cmd.request.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;

/**
 * @ClassName: WorkFlowAddTaskOperationCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.task
 * @Description: the work flow add task operation cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/2
 * @Version: 1.0
 */
public class WorkFlowAddTaskOperationCmdRequest extends WorkFlowGenericCmdRequest<Void> {

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

    //  the due date
    private String dueDate;

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
