package com.wb.workflow.core.cmd.request.model;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowCreateModelCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.model
 * @Description: the work flow create model cmd request
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public class WorkFlowCreateModelCmdRequest extends WorkFlowGenericCmdRequest<String> {

    //  流程定义CODE,唯一标识
    private String code;

    //  流程名称
    private String name;

    //  流程描述
    private String description;

    //  流程所属分组
    private String groupId;

    //  流程状态
    private String publishStatus;

    //  流程定义ID
    private String fDefinitionId;

    //  流程模型ID
    private String fModelId;

    //  流程发布ID
    private String fDeployId;

    //  版本号
    private String version;

    //  是否主版本（1是，0不是）
    private String isMainVersion;

    //  流程文件
    private String json_xml;

    //  图片文件
    private String svg_xml;

    //  是否部署（1是，0不是）
    private String isDeployment;

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
}
