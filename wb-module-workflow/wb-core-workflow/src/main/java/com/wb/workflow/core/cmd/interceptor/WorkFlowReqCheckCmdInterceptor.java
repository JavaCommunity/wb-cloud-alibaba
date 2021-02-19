package com.wb.workflow.core.cmd.interceptor;

import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowReqCheckCmdInterceptor
 * @Package: com.wb.workflow.core.cmd.interceptor
 * @Description: the work flow req check cmd interceptor
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowReqCheckCmdInterceptor extends AbstractWorkFlowCmdInterceptor {

    @Override
    public <T> T execute(WorkFlowCmd cmd, WorkFlowGenericCmdRequest<T> cmdRequest) {
        cmdRequest.check();
        return super.execute(cmd, cmdRequest);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
