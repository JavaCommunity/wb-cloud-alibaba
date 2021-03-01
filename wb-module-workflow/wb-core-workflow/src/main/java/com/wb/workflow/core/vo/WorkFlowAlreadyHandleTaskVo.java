package com.wb.workflow.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName: WorkFlowAlreadyHandleTaskVo
 * @Package: com.wb.workflow.core.vo
 * @Description: 已办理流程任务vo
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@ApiModel(value = "WorkFlowAlreadyHandleTaskVo", description = "已办理流程任务vo")
public class WorkFlowAlreadyHandleTaskVo {

    @ApiModelProperty(value = "任务ID")
    private String taskId;

    @ApiModelProperty(value = "任务名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "持续时间")
    private Date dueDate;

    public WorkFlowAlreadyHandleTaskVo(String taskId, String name, Date createTime, Date endTime, Date dueDate) {
        this.taskId = taskId;
        this.name = name;
        this.createTime = createTime;
        this.endTime = endTime;
        this.dueDate = dueDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
