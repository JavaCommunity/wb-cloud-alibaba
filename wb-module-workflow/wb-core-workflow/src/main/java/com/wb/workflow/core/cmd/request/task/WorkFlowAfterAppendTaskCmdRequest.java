package com.wb.workflow.core.cmd.request.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

import java.util.List;

/**
 * @ClassName: WorkFlowAfterAppendTaskCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.task
 * @Description: the work flow after append task cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowAfterAppendTaskCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    //  the user id
    private String userId;

    //  the by append after user
    private List<String> byAppendUser;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getByAppendUser() {
        return byAppendUser;
    }

    public void setByAppendUser(List<String> byAppendUser) {
        this.byAppendUser = byAppendUser;
    }
}
