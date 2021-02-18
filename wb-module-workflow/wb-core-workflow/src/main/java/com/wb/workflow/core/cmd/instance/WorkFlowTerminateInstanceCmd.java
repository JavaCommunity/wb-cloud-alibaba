package com.wb.workflow.core.cmd.instance;

import com.wb.workflow.core.cmd.WorkFlowCmd;

/**
 * @ClassName: WorkFlowTerminateInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the terminate instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowTerminateInstanceCmd<T> extends AbstractWorkFlowInstanceCmd implements WorkFlowCmd<Void> {

    @Override
    public Void execute() {
        return null;
    }
}
