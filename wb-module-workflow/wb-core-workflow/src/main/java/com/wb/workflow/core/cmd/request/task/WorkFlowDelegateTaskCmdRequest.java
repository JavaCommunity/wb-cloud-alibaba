package com.wb.workflow.core.cmd.request.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.utils.WorkFlowReqCheckUtils;

/**
 * @ClassName: WorkFlowDelegateTaskCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.task
 * @Description: the work flow delegate task cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowDelegateTaskCmdRequest extends WorkFlowGenericCmdRequest<Void> {

    //  the delegate user id
    private String delegateUserId;

    @Override
    public void check() {
        WorkFlowReqCheckUtils.checkEmpty(delegateUserId, "delegateUserId");
    }

    public String getDelegateUserId() {
        return delegateUserId;
    }

    public void setDelegateUserId(String delegateUserId) {
        this.delegateUserId = delegateUserId;
    }
}
