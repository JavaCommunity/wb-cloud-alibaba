package com.wb.flowable.ext.api.definition;

import com.wb.flowable.ext.api.config.FlowableErrorEnum;
import com.wb.flowable.ext.api.utils.FlowableReqCheckUtils;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: DefaultFlowableDefinitionExt
 * @Package: com.wb.flowable.ext.api.definition
 * @Description: the default flowable definition ext
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
@Component
public class DefaultFlowableDefinitionExt implements FlowableDefinitionExt {

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public void checkForId(String definitionId) {
        FlowableReqCheckUtils.checkEmpty(definitionId, "definitionId");

        ProcessDefinition processDefinition = this.queryForId(definitionId);
        if (ObjectUtils.isEmpty(processDefinition)) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_DEFINITION.getMsg());
        }
    }

    @Override
    public ProcessDefinition queryForId(String definitionId) {
        FlowableReqCheckUtils.checkEmpty(definitionId, "definitionId");

        return repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionId(definitionId)
                .singleResult();
    }

    @Override
    public ProcessDefinition queryForDeployId(String deployId) {
        FlowableReqCheckUtils.checkEmpty(deployId, "deployId");

        return repositoryService
                .createProcessDefinitionQuery()
                .deploymentId(deployId)
                .singleResult();
    }
}
