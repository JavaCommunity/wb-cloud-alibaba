package com.wb.workflow.core.cmd.interceptor;

/**
 * @ClassName: WorkFlowCmdInterceptorOrder
 * @Package: com.wb.workflow.core.cmd.interceptor
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
}
