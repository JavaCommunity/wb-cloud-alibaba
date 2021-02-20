package com.wb.workflow.service.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.wb.flowable.ext.api.model.FlowableModelExt;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: WorkFlowModelerController
 * @Package: com.wb.workflow.service.controller
 * @Description: the work flow modeler controller
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/workFlow/modeler/")
@Api(value = "工作流程模型接口", tags = "工作流程模型接口API")
public class WorkFlowModelerController {

    @Autowired
    private WorkFlowDefinitionService definitionService;

    @Autowired
    private FlowableModelExt modelExt;

    @ApiOperation(value = "根据模型ID查询模型信息", notes = "根据模型ID查询模型信息", httpMethod = "GET", code = 9999)
    @RequestMapping(value = "v1/queryModelForId", method = RequestMethod.GET)
    public ObjectNode queryWorkFlowModelForId(@RequestParam(value = "id") String id) {
        WorkFlowDefinitionEntity definitionEntity = definitionService.queryForId(id);
        Assert.notNull(definitionEntity, "not found workFlow definition info,id=" + id);

        String fModelId = definitionEntity.getfModelId();
        ObjectNode objectNode = modelExt.queryForId(fModelId);
        Assert.hasText(fModelId, "not found workFlow model info,id=" + id);
        JsonNode jsonNode = new TextNode(id);
        objectNode.set("modelId", jsonNode);
        return objectNode;
    }
}
