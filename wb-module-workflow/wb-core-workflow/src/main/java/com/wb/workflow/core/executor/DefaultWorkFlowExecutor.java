package com.wb.workflow.core.executor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.WorkFlowCmdInterceptor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DefaultWorkFlowExecutor
 * @Package: com.wb.workflow.core.executor
 * @Description: the default work flow executor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class DefaultWorkFlowExecutor implements WorkFlowExecutor {

    //  the first cmd interceptor
    private WorkFlowCmdInterceptor firstCmdInterceptor;

    @Override
    public <T> T execute(WorkFlowCmd<T> cmd) {
        return this.firstCmdInterceptor.execute(cmd);
    }

    @Override
    public void setCmdInterceptor(WorkFlowCmdInterceptor cmdInterceptor) {
        this.firstCmdInterceptor = cmdInterceptor;
    }
}
