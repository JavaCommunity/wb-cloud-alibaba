package com.wb.workflow.core.cmd.request.definition;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;

/**
 * @ClassName: WorkFlowCreateDefinitionCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.definition
 * @Description: the work flow create definition cmd request
 * @Author：[bo.wang]
 * @Date: 2021/2/26
 * @Version: 1.0
 */
public class WorkFlowCreateDefinitionCmdRequest extends WorkFlowGenericCmdRequest<String> {

    //  the code
    private String code;

    //  the name
    private String name;

    //  the group id
    private String groupId;

    //  the publish status
    private String publishStatus;

    //  the description
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
