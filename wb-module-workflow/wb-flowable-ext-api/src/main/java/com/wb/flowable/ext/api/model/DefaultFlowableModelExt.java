package com.wb.flowable.ext.api.model;

import com.alibaba.fastjson.JSONObject;
import com.wb.flowable.ext.api.config.FlowableConstants;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

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
            modelObjectNode.put(FlowableConstants.MODEL_NAME, request.getName());
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
}
