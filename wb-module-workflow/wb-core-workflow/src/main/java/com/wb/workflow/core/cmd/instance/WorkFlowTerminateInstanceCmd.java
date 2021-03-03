package com.wb.workflow.core.cmd.instance;

import com.wb.flowable.ext.api.instance.FlowableInstanceExt;
import com.wb.flowable.ext.api.model.FlowableModelExt;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.instance.WorkFlowTerminateInstanceCmdRequest;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import com.wb.workflow.core.exception.WorkFlowObjectNotFoundException;
import org.flowable.bpmn.model.EndEvent;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName: WorkFlowTerminateInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the terminate instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowTerminateInstanceCmd extends AbstractWorkFlowInstanceCmd {

    @Autowired
    private FlowableInstanceExt instanceExt;

    @Autowired
    private FlowableModelExt modelExt;

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowInstanceEntity instance = cmdRequest.getInstance();
        ProcessInstance processInstance = instanceExt.queryForId(instance.getfInstanceId());
        if (ObjectUtils.isEmpty(processInstance)) {
            throw new WorkFlowObjectNotFoundException(WorkFlowErrorEnum.NOT_FOUND_INSTANCE.getMsg(), WorkFlowTerminateInstanceCmd.class);
        }
        List<EndEvent> endEventList = modelExt.queryEndFlowElement(instance.getfDefinitionId());
        if (CollectionUtils.isEmpty(endEventList)) {
            throw new WorkFlowObjectNotFoundException(WorkFlowErrorEnum.NOT_FOUND_END_EVENT.getMsg(), WorkFlowTerminateInstanceCmd.class);
        }
        List<String> executionInstanceIdList = instanceExt.queryExecutionInstanceIdList(processInstance.getId());
        if (CollectionUtils.isEmpty(executionInstanceIdList)) {
            throw new WorkFlowObjectNotFoundException(WorkFlowErrorEnum.NOT_FOUND_EXECUTE_INSTANCE.getMsg(), WorkFlowTerminateInstanceCmd.class);
        }
        instanceExt.jumpToActivityNode(executionInstanceIdList, endEventList.get(0).getId());
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowTerminateInstanceCmdRequest.class;
    }
}
