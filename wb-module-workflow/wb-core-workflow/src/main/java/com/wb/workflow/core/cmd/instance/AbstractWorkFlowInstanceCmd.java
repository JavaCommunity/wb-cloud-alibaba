package com.wb.workflow.core.cmd.instance;

import com.wb.workflow.core.cmd.WorkFlowCmd;

/**
 * @ClassName: AbstractWorkFlowInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the abstract instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public abstract class AbstractWorkFlowInstanceCmd implements WorkFlowCmd {

    /**
     * is suspended with the specified status
     *
     * @param status the status
     */
    protected void isSuspended(String status) {

    }
}
