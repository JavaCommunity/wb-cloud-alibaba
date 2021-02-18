package com.wb.workflow.core.cmd;

/**
 * @ClassName: WorkFlowCmd
 * @Package: com.wb.workflow.core.cmd
 * @Description: the workFlow command interface
 * @Author：[bo.wang]
 * @Date: 2021/2/10
 * @Version: 1.0
 */
public interface WorkFlowCmd<T> {

    /**
     * execute command
     *
     * @return
     */
    T execute();

    /**
     * the before execute command
     */
    default void before() {
    }

    /**
     * the after execute command
     */
    default void after() {
    }

    /**
     * the check command
     */
    default void check() {
    }
}
