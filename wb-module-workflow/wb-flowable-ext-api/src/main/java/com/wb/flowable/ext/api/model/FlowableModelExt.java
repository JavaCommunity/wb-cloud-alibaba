package com.wb.flowable.ext.api.model;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.EndEvent;
import org.flowable.engine.repository.Model;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName: FlowableModelExt
 * @Package: com.wb.flowable.ext.api.model
 * @Description: the flowable model ext
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public interface FlowableModelExt {

    /**
     * create model with the specified flowable model request
     *
     * @param request the flowable model request
     * @return the model id
     */
    String create(FlowableModelRequest request);

    /**
     * query model with the specified model id
     *
     * @param modelId the model id
     * @return the model
     */
    ObjectNode queryForId(String modelId);

    /**
     * query end flow element with the specified definition id
     *
     * @param definitionId the definition id
     * @return the end event element
     */
    List<EndEvent> queryEndFlowElement(String definitionId);

    /**
     * query bpmn model with the specified definition id
     *
     * @param definitionId the definition id
     * @return the bpmn model
     */
    BpmnModel queryForDefinitionId(String definitionId);

    /**
     * validation bpmn model with the specified json xml
     *
     * @param jsonXml the json xml
     */
    void validationBpmnModel(String jsonXml);

    /**
     * update model with the specified flowableModelRequest.
     *
     * @param modelRequest the flowableModelRequest
     */
    void update(FlowableModelRequest modelRequest);

    /**
     * query model with the specified the model is
     *
     * @param modelId the model id
     * @return the model
     */
    Model queryModelForId(String modelId);
}
