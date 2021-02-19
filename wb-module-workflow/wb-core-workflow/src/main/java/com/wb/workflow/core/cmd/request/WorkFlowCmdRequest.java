package com.wb.workflow.core.cmd.request;

/**
 * @ClassName: WorkFlowCmdRequest
 * @Package: com.wb.workflow.core.cmd.request
 * @Description: the work flow cmd request
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
public interface WorkFlowCmdRequest<T> {

    //  the check request
    default void check() {

    }
}
