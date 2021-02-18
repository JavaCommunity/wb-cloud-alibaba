package com.wb.workflow.core.cmd.model;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowCreateModelCmd
 * @Package: com.wb.workflow.core.cmd.model
 * @Description: the work flow create model cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowCreateModelCmd<T> implements WorkFlowCmd<String> {

    @Override
    public String execute() {
        return null;
    }
}
