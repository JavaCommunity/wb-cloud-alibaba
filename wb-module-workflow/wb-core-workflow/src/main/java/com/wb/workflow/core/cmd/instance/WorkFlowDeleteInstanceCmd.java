package com.wb.workflow.core.cmd.instance;

import com.wb.workflow.core.cmd.WorkFlowCmd;

/**
 * @ClassName: WorkFlowDeleteInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the delete instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowDeleteInstanceCmd<T> extends AbstractWorkFlowInstanceCmd implements WorkFlowCmd<Void> {

    @Override
    public Void execute() {
        return null;
    }
}
