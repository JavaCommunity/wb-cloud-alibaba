package com.wb.workflow.core.cmd.request.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowTurnTaskCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.task
 * @Description: the work flow turn task cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowTurnTaskCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    //  the turn user id
    private String turnUserId;

    public String getTurnUserId() {
        return turnUserId;
    }

    public void setTurnUserId(String turnUserId) {
        this.turnUserId = turnUserId;
    }
}
