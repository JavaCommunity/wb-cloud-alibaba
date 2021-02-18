package com.wb.workflow.core.cmd;

/**
 * @ClassName: WorkFlowCmdInterceptorOrder
 * @Package: com.wb.workflow.core.cmd
 * @Description: the workFlow cmd interceptor order
 * @Author：[bo.wang]
 * @Date: 2021/2/10
 * @Version: 1.0
 */
public interface WorkFlowCmdInterceptorOrder {

    /**
     * get order
     *
     * @return the order number
     */
    int getOrder();

    /**
     * set next cmd interceptor
     *
     * @param next the next cmd interceptor
     */
    void setNext(WorkFlowCmdInterceptor next);
}
