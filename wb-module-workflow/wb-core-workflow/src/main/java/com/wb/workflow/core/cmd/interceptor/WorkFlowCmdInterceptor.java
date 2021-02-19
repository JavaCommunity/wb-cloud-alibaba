package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowCmdInterceptor
 * @Package: com.wb.workflow.core.cmd.interceptor
 * @Description: the workFlow cmd interceptor
 * @Author：[bo.wang]
 * @Date: 2021/2/10
 * @Version: 1.0
 */
public interface WorkFlowCmdInterceptor extends WorkFlowCmdInterceptorOrder {

    /**
     * execute command
     *
     * @param cmd        cmd the command
     * @param cmdRequest the cmd request
     * @param <T>
     * @return
     */
    <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest);

    /**
     * set next cmd interceptor
     *
     * @param next the next cmd interceptor
     */
    void setNext(WorkFlowCmdInterceptor next);

    /**
     * enable cmd interceptor
     *
     * @return <tt>true<tt/> enable cmd interceptor
     */
    default boolean enable() {
        return true;
    }
}
