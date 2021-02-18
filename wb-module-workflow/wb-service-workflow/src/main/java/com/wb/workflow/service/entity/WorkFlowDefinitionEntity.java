package com.wb.workflow.service.entity;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: WorkFlowDefinitionEntity
 * @Package: com.wb.workflow.service.entity
 * @Description: the work flow definition entity
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowDefinitionEntity extends BaseEntity {

    /**
     * 流程定义CODE,唯一标识
     */
    private String code;

    /**
     * 流程名称
     */
    private String name;

    /**
     * 流程描述
     */
    private String description;

    /**
     * 流程所属分组
     */
    private String groupId;

    /**
     * 流程状态
     */
    private String publishStatus;

    /**
     * 流程定义ID
     */
    private String fDefinitionId;

    /**
     * 流程模型ID
     */
    private String fModelId;

    /**
     * 流程发布ID
     */
    private String fDeployId;

    /**
     * 版本号
     */
    private String version;

    /**
     * 是否主版本（1是，0不是）
     */
    private String isMainVersion;

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
}
