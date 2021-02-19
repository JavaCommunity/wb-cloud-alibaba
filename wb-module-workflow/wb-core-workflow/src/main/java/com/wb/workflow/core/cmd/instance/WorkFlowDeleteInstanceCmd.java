package com.wb.workflow.core.cmd.instance;

import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;

/**
 * @ClassName: WorkFlowDeleteInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the delete instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowDeleteInstanceCmd extends AbstractWorkFlowInstanceCmd {

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return null;
    }
}
