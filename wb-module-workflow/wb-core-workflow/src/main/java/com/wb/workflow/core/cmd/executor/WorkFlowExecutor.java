package com.wb.workflow.core.cmd.executor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.interceptor.WorkFlowCmdInterceptor;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowExecute
 * @Package: com.wb.workflow.core.cmd.executor
 * @Description: the work flow executor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface WorkFlowExecutor {

    /**
     * execute command
     *
     * @param cmd        the command
     * @param cmdRequest the cmd request
     * @param <T>
     * @return
     */
    <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest);

    /**
     * set cmd interceptor
     *
     * @param cmdInterceptor the cmd interceptor
     */
    void setCmdInterceptor(WorkFlowCmdInterceptor cmdInterceptor);
}
