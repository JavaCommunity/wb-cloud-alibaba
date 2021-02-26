package com.wb.workflow.core.cmd;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowCmd
 * @Package: com.wb.workflow.core.cmd
 * @Description: the workFlow command interface
 * @Author：[bo.wang]
 * @Date: 2021/2/10
 * @Version: 1.0
 */
public interface WorkFlowCmd {

    /**
     * execute command
     *
     * @return
     */
    <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest);

    /**
     * the before execute command
     *
     * @param cmdRequest this cmd request
     */
    default void before(WorkFlowGenericCmdRequest cmdRequest) {
    }

    /**
     * the after execute command
     *
     * @param cmdRequest this cmd request
     */
    default void after(WorkFlowGenericCmdRequest cmdRequest) {
    }

    /**
     * the check command
     *
     * @param cmdRequest this cmd request
     */
    default void check(WorkFlowGenericCmdRequest cmdRequest) {
    }

    /**
     * get request class
     *
     * @return the request class
     */
    Class<?> getReqClass();
}
