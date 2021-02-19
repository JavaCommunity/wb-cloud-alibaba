package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowBeforeCmdInterceptor
 * @Package: com.wb.workflow.core.cmd.interceptor
 * @Description: the before cmd interceptor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowBeforeCmdInterceptor extends AbstractWorkFlowCmdInterceptor {

    @Override
    public <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest) {
        cmd.before();
        return super.execute(cmd, cmdRequest);
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
