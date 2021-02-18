package com.wb.workflow.core.cmd.instance;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowSaveDraftInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the save draft instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowSaveDraftInstanceCmd<T> extends AbstractWorkFlowInstanceCmd implements WorkFlowCmd<Void> {

    @Override
    public Void execute() {
        return null;
    }
}
