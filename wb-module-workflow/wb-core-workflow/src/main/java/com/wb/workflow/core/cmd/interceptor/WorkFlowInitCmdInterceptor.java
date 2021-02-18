package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.WorkFlowCmdInterceptor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowInitCmdInterceptor
 * @Package: com.wb.workflow.core.cmd.interceptor
 * @Description: the init cmd interceptor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowInitCmdInterceptor extends AbstractWorkFlowCmdInterceptor implements WorkFlowCmdInterceptor {

    @Override
    public <T> T execute(WorkFlowCmd<T> cmd) {
        return super.execute(cmd);
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
