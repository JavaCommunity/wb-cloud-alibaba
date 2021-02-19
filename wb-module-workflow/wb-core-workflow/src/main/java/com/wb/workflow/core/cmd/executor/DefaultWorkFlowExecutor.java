package com.wb.workflow.core.cmd.executor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.interceptor.WorkFlowCmdInterceptor;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DefaultWorkFlowExecutor
 * @Package: com.wb.workflow.core.cmd.executor
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
    public <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest) {
        return this.firstCmdInterceptor.execute(cmd, cmdRequest);
    }

    @Override
    public void setCmdInterceptor(WorkFlowCmdInterceptor cmdInterceptor) {
        this.firstCmdInterceptor = cmdInterceptor;
    }
}
