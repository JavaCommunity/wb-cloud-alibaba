package com.wb.workflow.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @ClassName: WorkFlowTaskVo
 * @Package: com.wb.workflow.core.vo
 * @Description: 流程任务信息vo
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@ApiModel(value = "WorkFlowTaskVo", description = "流程任务信息vo")
public class WorkFlowTaskVo {

    @ApiModelProperty(value = "命令类型，详情可见：com.wb.workflow.core.config.WorkFlowCmdEnum")
    private String cmdType;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "任务ID")
    private String taskId;

    @ApiModelProperty(value = "流程变量")
    private Map<String, Object> variables;

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
