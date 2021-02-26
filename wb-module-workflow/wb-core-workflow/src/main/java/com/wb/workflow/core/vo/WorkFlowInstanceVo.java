package com.wb.workflow.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: WorkFlowInstanceVo
 * @Package: com.wb.workflow.core.vo
 * @Description: the work flow instance vo
 * @Author：[bo.wang]
 * @Date: 2021/2/26
 * @Version: 1.0
 */
@ApiModel(value = "WorkFlowInstanceVo", description = "流程实例信息vo")
public class WorkFlowInstanceVo {

    @ApiModelProperty(value = "命令类型，详情可见：com.wb.workflow.core.config.WorkFlowCmdEnum")
    private String cmdType;

    @ApiModelProperty(value = "流程定义主键ID")
    private String definitionId;

    @ApiModelProperty(value = "流程定义CODE")
    private String definitionCode;

    @ApiModelProperty(value = "流程定义名称")
    private String definitionName;

    @ApiModelProperty(value = "flowable流程定义ID")
    private String fDefinitionId;

    @ApiModelProperty(value = "flowable流程实例ID")
    private String fInstanceId;

    @ApiModelProperty(value = "flowable流程部署ID")
    private String fDeploymentId;

    @ApiModelProperty(value = "业务主键")
    private String businessKey;

    @ApiModelProperty(value = "流程实例状态")
    private String status;

    @ApiModelProperty(value = "流程实例标题")
    private String title;

    @ApiModelProperty(value = "流程实例结果")
    private String result;

    @ApiModelProperty(value = "设置信息")
    private String setJson;

    @ApiModelProperty(value = "描述信息")
    private String description;

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }

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
