package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowInvokerCmdInterceptor
 * @Package: com.wb.workflow.core.cmd.interceptor
 * @Description: the invoker cmd interceptor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowInvokerCmdInterceptor extends AbstractWorkFlowCmdInterceptor {

    @Override
    public <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest) {
        T result = cmd.execute(cmdRequest);
        super.execute(cmd, cmdRequest);
        return result;
    }

    @Override
    public int getOrder() {
        return 15;
    }
}
