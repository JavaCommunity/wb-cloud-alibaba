package com.wb.workflow.service.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName: WorkFlowDefinitionVo
 * @Package: com.wb.workflow.service.vo
 * @Description: the work flow definition vo
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@ApiModel(value = "WorkFlowDefinitionVo", description = "流程定义信息vo")
public class WorkFlowDefinitionVo {

    @ApiModelProperty(value = "流程定义主键ID")
    private String definitionId;

    @ApiModelProperty(value = "流程定义CODE,唯一标识")
    private String code;

    @ApiModelProperty(value = "流程名称")
    private String name;

    @ApiModelProperty(value = "流程描述")
    private String description;

    @ApiModelProperty(value = "流程所属分组")
    private String groupId;

    @ApiModelProperty(value = "流程状态，详情可见：com.wb.workflow.core.config.WorkFlowPublishStatusEnum")
    private String publishStatus;

    @ApiModelProperty(value = "流程定义ID")
    private String fDefinitionId;

    @ApiModelProperty(value = "流程模型ID")
    private String fModelId;

    @ApiModelProperty(value = "流程发布ID")
    private String fDeployId;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "是否主版本（1是，0不是）")
    private String isMainVersion;

    @ApiModelProperty(value = "流程文件")
    private String json_xml;

    @ApiModelProperty(value = "图片文件")
    private String svg_xml;

    @ApiModelProperty(value = "是否部署（1是，0不是）")
    private String isDeployment;

    /*****************流程挂起 start*******************/
    @ApiModelProperty(value = "是否级联挂起该流程定义下的流程实例")
    private boolean suspendProcessInstances;

    @ApiModelProperty(value = "设置挂起这个流程定义的时间，如果不填写，则立即挂起")
    private Date suspensionDate;
    /*****************流程挂起 end*******************/

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getfDefinitionId() {
        return fDefinitionId;
    }

    public void setfDefinitionId(String fDefinitionId) {
        this.fDefinitionId = fDefinitionId;
    }

    public String getfModelId() {
        return fModelId;
    }

    public void setfModelId(String fModelId) {
        this.fModelId = fModelId;
    }

    public String getfDeployId() {
        return fDeployId;
    }

    public void setfDeployId(String fDeployId) {
        this.fDeployId = fDeployId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIsMainVersion() {
        return isMainVersion;
    }

    public void setIsMainVersion(String isMainVersion) {
        this.isMainVersion = isMainVersion;
    }

    public String getJson_xml() {
        return json_xml;
    }

    public void setJson_xml(String json_xml) {
        this.json_xml = json_xml;
    }

    public String getSvg_xml() {
        return svg_xml;
    }

    public void setSvg_xml(String svg_xml) {
        this.svg_xml = svg_xml;
    }

    public String getIsDeployment() {
        return isDeployment;
    }

    public void setIsDeployment(String isDeployment) {
        this.isDeployment = isDeployment;
    }

    public boolean isSuspendProcessInstances() {
        return suspendProcessInstances;
    }

    public void setSuspendProcessInstances(boolean suspendProcessInstances) {
        this.suspendProcessInstances = suspendProcessInstances;
    }

    public Date getSuspensionDate() {
        return suspensionDate;
    }

    public void setSuspensionDate(Date suspensionDate) {
        this.suspensionDate = suspensionDate;
    }
}
