package com.wb.workflow.core.cmd.request.task;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.vo.WorkFlowAlreadyHandleTaskVo;

import java.util.List;

/**
 * @ClassName: WorkFlowGetAlreadyHandleTaskCmdRequest
 * @Package: com.wb.workflow.core.cmd.request.task
 * @Description: the work flow get already handle task cmd request
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
public class WorkFlowGetAlreadyHandleTaskCmdRequest extends WorkFlowGenericCmdRequest<List<WorkFlowAlreadyHandleTaskVo>> {

    //  the user id
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
