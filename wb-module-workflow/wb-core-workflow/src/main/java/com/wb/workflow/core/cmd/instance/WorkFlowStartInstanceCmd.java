package com.wb.workflow.core.cmd.instance;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowStartInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the start instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowStartInstanceCmd extends AbstractWorkFlowInstanceCmd {

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return null;
    }
}
