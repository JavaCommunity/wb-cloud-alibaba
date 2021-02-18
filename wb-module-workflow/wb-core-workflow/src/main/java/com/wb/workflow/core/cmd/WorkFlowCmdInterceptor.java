package com.wb.workflow.core.cmd;

/**
 * @ClassName: WorkFlowCmdInterceptor
 * @Package: com.wb.workflow.core.cmd
 * @Description: the workFlow cmd interceptor
 * @Author：[bo.wang]
 * @Date: 2021/2/10
 * @Version: 1.0
 */
public interface WorkFlowCmdInterceptor extends WorkFlowCmdInterceptorOrder {

    /**
     * execute command
     *
     * @param cmd the command
     * @param <T>
     * @return
     */
    <T> T execute(WorkFlowCmd<T> cmd);

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
