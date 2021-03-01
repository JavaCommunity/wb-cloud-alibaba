package com.wb.workflow.core.cmd.request.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.vo.WorkFlowWaitHandleTaskVo;

import java.util.List;

/**
 * @ClassName: WorkFlowGetWaitHandleCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.task
 * @Description: the work flow get wait handle task cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowGetWaitHandleTaskCmdRequest extends WorkFlowGenericCmdRequest<List<WorkFlowWaitHandleTaskVo>> {

    //  the user id
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
