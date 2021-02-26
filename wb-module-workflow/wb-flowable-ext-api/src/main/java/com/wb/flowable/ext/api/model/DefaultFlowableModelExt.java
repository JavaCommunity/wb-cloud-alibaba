package com.wb.flowable.ext.api.model;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wb.flowable.ext.api.config.FlowableConstants;
import com.wb.flowable.ext.api.config.FlowableErrorEnum;
import com.wb.flowable.ext.api.utils.FlowableReqCheckUtils;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.EndEvent;
import org.flowable.bpmn.model.Process;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.api.FlowableIllegalArgumentException;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Model;
import org.flowable.validation.ProcessValidator;
import org.flowable.validation.ProcessValidatorFactory;
import org.flowable.validation.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

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

    @Override
    public List<EndEvent> queryEndFlowElement(String definitionId) {
        FlowableReqCheckUtils.checkEmpty(definitionId, "definitionId");
        BpmnModel bpmnModel = queryForDefinitionId(definitionId);
        if (ObjectUtils.isEmpty(bpmnModel)) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_MODEL.getMsg());
        }
        Process mainProcess = bpmnModel.getMainProcess();
        return mainProcess.findFlowElementsOfType(EndEvent.class, false);
    }

    @Override
    public BpmnModel queryForDefinitionId(String definitionId) {
        FlowableReqCheckUtils.checkEmpty(definitionId, "definitionId");

        return repositoryService.getBpmnModel(definitionId);
    }

    @Override
    public void validationBpmnModel(String jsonXml) {
        if (!StringUtils.hasText(jsonXml)) {
            throw new FlowableIllegalArgumentException(FlowableErrorEnum.MODEL_IS_NULL.getMsg());
        }
        ObjectNode modelNode = null;
        try {
            modelNode = (ObjectNode) (new ObjectMapper()).readTree(jsonXml);
        } catch (Exception e) {
            log.error("[Flowable Ext Api] Validation Model Error,ErrMsg:{}", e.getMessage());
            throw new FlowableException(e.getMessage());
        }
        BpmnModel bpmnModel = (new BpmnJsonConverter()).convertToBpmnModel(modelNode);
        ProcessValidatorFactory processValidatorFactory = new ProcessValidatorFactory();
        ProcessValidator defaultProcessValidator = processValidatorFactory.createDefaultProcessValidator();
        List<ValidationError> validationErrorList = defaultProcessValidator.validate(bpmnModel);
        if (!CollectionUtils.isEmpty(validationErrorList)) {
            throw new FlowableException(FlowableErrorEnum.MODEL_ERROR.getMsg());
        }
    }

    @Override
    public void update(FlowableModelRequest modelRequest) {
        FlowableReqCheckUtils.checkEmpty(modelRequest, "modelRequest");

        String modelId = modelRequest.getModelId();
        Model model = this.queryModelForId(modelId);
        if (ObjectUtils.isEmpty(model)) {
            throw new FlowableObjectNotFoundException(FlowableErrorEnum.NOT_FOUND_MODEL.getMsg());
        }

        byte[] jsonXmlBytes = null;
        try {
            jsonXmlBytes = modelRequest.getJsonXml().getBytes(FlowableConstants.CHARSET);
        } catch (Exception e) {
            throw new FlowableException(e.getMessage());
        }
        repositoryService.addModelEditorSource(modelId, jsonXmlBytes);

        String svgXml = modelRequest.getSvgXml();
        if (!StringUtils.isEmpty(svgXml)) {
            return;
        }
        try (InputStream svgStream = new ByteArrayInputStream(svgXml.getBytes(FlowableConstants.CHARSET));
             ByteArrayOutputStream outStream = new ByteArrayOutputStream()) {
            TranscoderInput input = new TranscoderInput(svgStream);
            PNGTranscoder transcoder = new PNGTranscoder();
            TranscoderOutput output = new TranscoderOutput(outStream);
            transcoder.transcode(input, output);
            final byte[] result = outStream.toByteArray();
            repositoryService.addModelEditorSourceExtra(modelId, result);
        } catch (Exception e) {
            log.error("[Flowable Ext Api] Update Model Error,ErrMsg:{}", e.getMessage());
            throw new FlowableException(e.getMessage());
        }
    }

    @Override
    public Model queryModelForId(String modelId) {
        FlowableReqCheckUtils.checkEmpty(modelId, "modelId");

        return repositoryService.getModel(modelId);
    }
}
