package com.wb.workflow.core.cmd.request.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowClaimTaskCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.task
 * @Description: the work flow chaim task cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowClaimTaskCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    //  the chaim user id
    private String chaimUserId;

    public String getChaimUserId() {
        return chaimUserId;
    }

    public void setChaimUserId(String chaimUserId) {
        this.chaimUserId = chaimUserId;
    }
}
