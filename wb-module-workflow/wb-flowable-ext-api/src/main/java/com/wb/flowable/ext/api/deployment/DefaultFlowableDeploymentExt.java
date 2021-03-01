package com.wb.flowable.ext.api.deployment;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wb.flowable.ext.api.config.FlowableConstants;
import com.wb.flowable.ext.api.config.FlowableErrorEnum;
import com.wb.flowable.ext.api.model.FlowableModelExt;
import com.wb.flowable.ext.api.utils.FlowableReqCheckUtils;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: DefaultFlowableDeploymentExt
 * @Package: com.wb.flowable.ext.api.deployment
 * @Description: the default flowable deployment ext
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
@Component
public class DefaultFlowableDeploymentExt implements FlowableDeploymentExt {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private FlowableModelExt modelExt;

    @Override
    public void checkForId(String deploymentId) {
        FlowableReqCheckUtils.checkEmpty(deploymentId, "deploymentId");

        if (ObjectUtils.isEmpty(queryForId(deploymentId))) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_DEPLOYMENT.getMsg());
        }
    }

    @Override
    public Deployment queryForId(String deploymentId) {
        FlowableReqCheckUtils.checkEmpty(deploymentId, "deploymentId");

        return repositoryService
                .createDeploymentQuery()
                .deploymentId(deploymentId)
                .singleResult();
    }

    @Override
    public Deployment deploy(String modelId, String code) {
        FlowableReqCheckUtils.checkEmpty(modelId, "modelId");

        Model model = modelExt.queryModelForId(modelId);
        if (ObjectUtils.isEmpty(model)) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_MODEL.getMsg());
        }

        ObjectNode modelNode = modelExt.queryModelEditorSource(model.getId());
        if (ObjectUtils.isEmpty(modelNode)) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_MODEL.getMsg());
        }
        BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(bpmnModel);

        Deployment deployment = null;
        try {
            deployment = repositoryService
                    .createDeployment()
                    .name(model.getName())
                    .addString(code + FlowableConstants.BPMN_SUFFIX, new String(bpmnBytes, FlowableConstants.CHARSET))
                    .deploy();
        } catch (Exception e) {
            throw new FlowableException(FlowableErrorEnum.DEPLOYMENT.getMsg());
        }
        model.setDeploymentId(deployment.getId());
        repositoryService.saveModel(model);
        return deployment;
    }
}
