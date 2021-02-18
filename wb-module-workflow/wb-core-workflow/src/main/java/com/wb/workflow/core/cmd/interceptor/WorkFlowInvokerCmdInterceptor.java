package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.WorkFlowCmdInterceptor;
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
public class WorkFlowInvokerCmdInterceptor extends AbstractWorkFlowCmdInterceptor implements WorkFlowCmdInterceptor {

    @Override
    public <T> T execute(WorkFlowCmd<T> cmd) {
        T result = cmd.execute();
        super.execute(cmd);
        return result;
    }

    @Override
    public int getOrder() {
        return 15;
    }
}
