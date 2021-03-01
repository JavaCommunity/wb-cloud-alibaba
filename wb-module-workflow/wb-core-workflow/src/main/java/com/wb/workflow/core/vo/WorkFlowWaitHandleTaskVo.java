package com.wb.workflow.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName: WorkFlowWaitHandleTaskVo
 * @Package: com.wb.workflow.core.vo
 * @Description: 等待办理流程任务vo
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@ApiModel(value = "WorkFlowWaitHandleTaskVo", description = "等待办理流程任务vo")
public class WorkFlowWaitHandleTaskVo {

    @ApiModelProperty(value = "流程实例")
    private String instanceId;

    @ApiModelProperty(value = "任务ID")
    private String taskId;

    @ApiModelProperty(value = "任务名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public WorkFlowWaitHandleTaskVo(String taskId, String name, Date createTime) {
        this.taskId = taskId;
        this.name = name;
        this.createTime = createTime;
    }

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
}
