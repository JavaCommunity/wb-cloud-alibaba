package com.wb.workflow.core.cmd.model;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
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
public class WorkFlowCreateModelCmd implements WorkFlowCmd {

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {

        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return null;
    }
}
