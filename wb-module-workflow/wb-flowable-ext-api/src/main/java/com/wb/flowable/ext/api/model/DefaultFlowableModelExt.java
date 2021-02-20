package com.wb.flowable.ext.api.model;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wb.flowable.ext.api.config.FlowableConstants;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import static com.wb.flowable.ext.api.config.FlowableConstants.MODEL_NAME;

/**
 * @ClassName: DefaultFlowableModelExt
 * @Package: com.wb.flowable.ext.api.model
 * @Description: the default flowable model ext
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class DefaultFlowableModelExt implements FlowableModelExt {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DefaultFlowableModelExt.class);

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String create(FlowableModelRequest request) {
        try {
            Assert.notNull(request, "'request' must not be null！");

            JSONObject stencilSet = new JSONObject();
            stencilSet.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            JSONObject editorNode = new JSONObject();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            editorNode.put("stencilset", stencilSet);
            JSONObject modelObjectNode = new JSONObject();
            modelObjectNode.put(FlowableConstants.MODEL_REVISION,
                    Integer.parseInt(FlowableConstants.DEFAULT_MODEL_REVISION));
            modelObjectNode.put(FlowableConstants.MODEL_DESCRIPTION, request.getDescription());
            modelObjectNode.put(FlowableConstants.MODEL_KEY, request.getCode());
            modelObjectNode.put(MODEL_NAME, request.getName());
            Model modelData = repositoryService.newModel();
            modelData.setMetaInfo(modelObjectNode.toJSONString());
            modelData.setName(request.getName());
            modelData.setKey(request.getCode());
            repositoryService.saveModel(modelData);
            repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes(FlowableConstants.CHARSET));
            return modelData.getId();
        } catch (Exception e) {
            log.error("[Flowable Ext Api] Model Create Error,ErrMsg:{}", e.getMessage());
            throw new FlowableException(e.getMessage());
        }
    }

    @Override
    public ObjectNode queryForId(String modelId) {
        try {
            Assert.hasLength(modelId, "'modelId' must not be null！");

            Model model = repositoryService.getModel(modelId);
            Assert.notNull(model, "not found model info,modelId=" + modelId);

            ObjectNode modelNode = null;
            if (!StringUtils.isEmpty(model.getMetaInfo())) {
                modelNode = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
            } else {
                modelNode = objectMapper.createObjectNode();
                modelNode.put(MODEL_NAME, model.getName());
            }
            modelNode.put(FlowableConstants.MODEL_ID, model.getId());
            ObjectNode editorJsonNode = (ObjectNode) objectMapper.readTree(new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
            modelNode.put("model", editorJsonNode);
            return modelNode;
        } catch (Exception e) {
            log.error("[Flowable Ext Api] Model Query Error,ErrMsg:{}", e.getMessage());
            throw new FlowableException(e.getMessage());
        }
    }
}
