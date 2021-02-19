package com.wb.workflow.service.controller;

import com.wb.common.result.R;
import com.wb.workflow.core.config.WorkFlowCmdEnum;
import com.wb.workflow.core.entity.WorkFlowDefinitionEntity;
import com.wb.workflow.core.service.WorkFlowDefinitionService;
import com.wb.workflow.core.vo.WorkFlowDefinitionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: WorkFlowDefinitionController
 * @Package: com.wb.workflow.service.controller
 * @Description: the work flow definition controller
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "workFlow/definition/")
@Api(value = "工作流流程定义接口", tags = "工作流流程定义接口API")
public class WorkFlowDefinitionController {

    @Autowired
    private WorkFlowDefinitionService definitionService;

    @ApiOperation(value = "保存工作流定义信息", notes = "保存工作流定义信息", httpMethod = "POST", code = 9999)
    @RequestMapping(value = "v1/save", method = RequestMethod.POST)
    public R v1Save(@RequestBody WorkFlowDefinitionVo definitionVo) {
        definitionVo.setCmdType(WorkFlowCmdEnum.CREATE_MODEL.getType());
        Object resultObj = definitionService.executeCmd(definitionVo);
        return R.ok().put("definitionId", resultObj);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "v1/update/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "修改工作流定义信息", notes = "修改工作流定义信息", httpMethod = "POST", code = 9999)
    public R v1Update(WorkFlowDefinitionVo workFlowDefinition) {
        WorkFlowDefinitionEntity workFlowDefinitionEntity = definitionService.update(workFlowDefinition);
        return R.ok().put("definitionId", workFlowDefinitionEntity.getId());
    }

    @RequestMapping(value = "v1/queryForId", method = RequestMethod.GET)
    @ApiOperation(value = "根据流程定义ID查询流程定义信息", notes = "根据流程定义ID查询流程定义信息",
            httpMethod = "GET", code = 9999)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "String", value = "流程定义主键ID")
    })
    public R v1QueryForId(@RequestParam(value = "id") String id) {
        WorkFlowDefinitionEntity workFlowDefinition = definitionService.queryForId(id);
        return R.ok().put("workFlowDefinition", workFlowDefinition);
    }

    @RequestMapping(value = "v1/executeCmd", method = RequestMethod.POST)
    @ApiOperation(value = "指定流程定义相关命令", notes = "指定流程定义相关命令", httpMethod = "POST", code = 9999)
    public R v1ExecuteCmd(@RequestBody WorkFlowDefinitionVo definitionVo) {
        Object resultObj = definitionService.executeCmd(definitionVo);
        return R.ok().data(resultObj);
    }
}
