package com.wb.workflow.core.executor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.WorkFlowCmdInterceptor;

/**
 * @ClassName: WorkFlowExecute
 * @Package: com.wb.workflow.core.execute
 * @Description: the work flow executor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface WorkFlowExecutor {

    /**
     * execute command
     *
     * @param cmd the command
     * @param <T>
     * @return
     */
    <T> T execute(WorkFlowCmd<T> cmd);

    /**
     * set cmd interceptor
     *
     * @param cmdInterceptor the cmd interceptor
     */
    void setCmdInterceptor(WorkFlowCmdInterceptor cmdInterceptor);
}
