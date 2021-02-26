package com.wb.workflow.core.cmd.instance;

import com.alibaba.fastjson.JSONObject;
import com.wb.flowable.ext.api.definition.FlowableDefinitionExt;
import com.wb.flowable.ext.api.deployment.FlowableDeploymentExt;
import com.wb.flowable.ext.api.instance.FlowableInstanceExt;
import com.wb.flowable.ext.api.instance.FlowableInstanceStartRequest;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.instance.WorkFlowStartInstanceCmdRequest;
import com.wb.workflow.core.config.WorkFlowContextHolder;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.config.WorkFlowInstanceStatusEnum;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.entity.WorkFlowInstanceEntity;
import com.wb.workflow.core.exception.WorkFlowException;
import com.wb.workflow.core.service.WorkFlowInstanceService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Map;

/**
 * @ClassName: WorkFlowStartInstanceCmd
 * @Package: com.wb.workflow.core.cmd.instance
 * @Description: the start instance cmd
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class WorkFlowStartInstanceCmd extends AbstractWorkFlowInstanceCmd {

    @Autowired
    private FlowableDefinitionExt definitionExt;

    @Autowired
    private FlowableDeploymentExt deploymentExt;

    @Autowired
    private FlowableInstanceExt instanceExt;

    @Autowired
    private WorkFlowInstanceService instanceService;

    @Override
    public void before(WorkFlowGenericCmdRequest cmdRequest) {
        WorkFlowDefinitionEntity definition = cmdRequest.getDefinition();

        //  the check flowable definition
        definitionExt.checkForId(definition.getfDefinitionId());
        //  the check flowable deployment
        deploymentExt.checkForId(definition.getfDeployId());
    }

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowStartInstanceCmdRequest request = (WorkFlowStartInstanceCmdRequest) cmdRequest;
        WorkFlowDefinitionEntity definition = cmdRequest.getDefinition();

        FlowableInstanceStartRequest startRequest = new FlowableInstanceStartRequest(
                WorkFlowContextHolder.getCurrentUserId(),
                definition.getfDefinitionId(),
                request.getBusinessKey(),
                request.getVariables()
        );
        ProcessInstance processInstance = instanceExt.start(startRequest);
        if (ObjectUtils.isEmpty(processInstance)) {
            throw new WorkFlowException(WorkFlowErrorEnum.START_INSTANCE.getMsg());
        }
        WorkFlowInstanceEntity instance = new WorkFlowInstanceEntity();
        BeanUtils.copyProperties(request, instance);
        instance.setSetJson(handleProcessVariable(request.getVariables()));
        instance.setDefinitionCode(definition.getCode());
        instance.setDefinitionId(definition.getId());
        instance.setfDefinitionId(definition.getfDefinitionId());
        instance.setfDeploymentId(definition.getfDeployId());
        instance.setfInstanceId(processInstance.getProcessInstanceId());
        instance.setStatus(WorkFlowInstanceStatusEnum.START.name());
        instanceService.save(instance);
        return (T) instance.getId();
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowStartInstanceCmdRequest.class;
    }

    /**
     * handle process variables
     *
     * @param variables the variables
     * @return the variables json
     */
    private String handleProcessVariable(Map<String, Object> variables) {
        if (CollectionUtils.isEmpty(variables)) {
            return null;
        }
        return JSONObject.toJSONString(variables);
    }
}
