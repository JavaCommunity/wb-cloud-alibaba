package com.wb.workflow.core.cmd.instance;

import com.wb.flowable.ext.api.instance.FlowableInstanceExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.instance.WorkFlowActivateInstanceCmdRequest;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.config.WorkFlowInstanceStatusEnum;
import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import com.wb.workflow.core.exception.WorkFlowException;
import com.wb.workflow.core.service.WorkFlowInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WorkFlowActivateInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the work flow activate instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowActivateInstanceCmd extends AbstractWorkFlowInstanceCmd {

    @Autowired
    private FlowableInstanceExt instanceExt;

    @Autowired
    private WorkFlowInstanceService instanceService;

    @Override
    public void check(WorkFlowGenericCmdRequest cmdRequest) {
        WorkFlowInstanceEntity instanceEntity = cmdRequest.getInstance();
        String status = instanceEntity.getStatus();
        if (WorkFlowInstanceStatusEnum.ACTIVATE.name().equalsIgnoreCase(status)) {
            throw new WorkFlowException(WorkFlowErrorEnum.REPEAT_EXECUTE.getMsg());
        }
    }

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowInstanceEntity instanceEntity = cmdRequest.getInstance();

        instanceExt.active(instanceEntity.getfInstanceId());
        instanceEntity.setStatus(WorkFlowInstanceStatusEnum.ACTIVATE.name());
        instanceService.update(instanceEntity);
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowActivateInstanceCmdRequest.class;
    }
}
