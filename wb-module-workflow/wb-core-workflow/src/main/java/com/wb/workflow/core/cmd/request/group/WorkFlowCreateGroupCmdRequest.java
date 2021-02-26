package com.wb.workflow.core.cmd.request.group;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowCreateGroupCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.group
 * @Description: the work flow create group cmd request
 * @Author：[bo.wang]
 * @Date: 2021/2/20
 * @Version: 1.0
 */
public class WorkFlowCreateGroupCmdRequest extends WorkFlowGenericCmdRequest<String> {

    //  the group name
    private String name;

    //  the group description
    private String description;

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
}
