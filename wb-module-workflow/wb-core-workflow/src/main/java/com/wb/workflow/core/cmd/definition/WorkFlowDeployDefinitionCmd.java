package com.wb.workflow.core.cmd.definition;

import com.wb.flowable.ext.api.definition.FlowableDefinitionExt;
import com.wb.flowable.ext.api.deployment.FlowableDeploymentExt;
import com.wb.workflow.core.cmd.WorkFlowCmd;
import com.wb.workflow.core.cmd.request.WorkFlowGenericCmdRequest;
import com.wb.workflow.core.cmd.request.definition.WorkFlowDeployDefinitionCmdRequest;
import com.wb.workflow.core.config.WorkFlowDefinitionStatusEnum;
import com.wb.workflow.core.config.WorkFlowErrorEnum;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.exception.WorkFlowException;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: WorkFlowDeployDefinitionCmd
 * @Package: com.wb.workflow.core.cmd.definition
 * @Description: the work flow deploy definition cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@Component
public class WorkFlowDeployDefinitionCmd implements WorkFlowCmd {

    @Autowired
    private FlowableDeploymentExt deploymentExt;

    @Autowired
    private FlowableDefinitionExt definitionExt;

    @Autowired
    private WorkFlowDefinitionService definitionService;

    @Override
    public void check(WorkFlowGenericCmdRequest cmdRequest) {
        WorkFlowDefinitionEntity definition = cmdRequest.getDefinition();
        if (WorkFlowDefinitionStatusEnum.DISABLE.name().equalsIgnoreCase(definition.getStatus())) {
            throw new WorkFlowException(WorkFlowErrorEnum.DEFINITION_DISABLE.getMsg());
        }
    }

    @Override
    public <T> T execute(WorkFlowGenericCmdRequest<T> cmdRequest) {
        WorkFlowDefinitionEntity definition = cmdRequest.getDefinition();
        Deployment deployment = deploymentExt.deploy(definition.getfModelId(), definition.getCode());
        if (ObjectUtils.isEmpty(deployment)) {
            throw new WorkFlowException(WorkFlowErrorEnum.DEPLOYMENT.getMsg());
        }

        String deploymentId = deployment.getId();
        ProcessDefinition processDefinition = definitionExt.queryForDeployId(deploymentId);
        definition.setfDefinitionId(processDefinition.getId());
        definition.setfDeployId(deploymentId);
        definition.setStatus(WorkFlowDefinitionStatusEnum.PUBLISH.name());
        definitionService.update(definition);
        return null;
    }

    @Override
    public Class<?> getReqClass() {
        return WorkFlowDeployDefinitionCmdRequest.class;
    }
}
