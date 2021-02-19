package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: AbstractWorkFlowCmdInterceptor
 * @Package: com.wb.workflow.core.cmd.interceptor
 * @Description: the abstract cmd interceptor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public abstract class AbstractWorkFlowCmdInterceptor implements WorkFlowCmdInterceptor {

    //  the cmd interceptor
    private WorkFlowCmdInterceptor next;

    /**
     * set next cmd interceptor
     *
     * @param next the next cmd interceptor
     */
    public void setNext(WorkFlowCmdInterceptor next) {
        this.next = next;
    }

    /**
     * execute cmd with the specified cmd
     *
     * @param cmd        cmd the command
     * @param cmdRequest the cmd request
     * @param <T>
     * @return
     */
    public <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest) {
        if (!ObjectUtils.isEmpty(next)) {
            return next.execute(cmd, cmdRequest);
        }
        return null;
    }
}
