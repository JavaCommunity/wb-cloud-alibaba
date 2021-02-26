package com.wb.workflow.service.controller;

import com.wb.common.result.R;
import com.wb.workflow.core.service.WorkFlowInstanceService;
import com.wb.workflow.core.vo.WorkFlowInstanceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: WorkFlowInstanceController
 * @Package: com.wb.workflow.service.controller
 * @Description: the work flow instance controller
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "workFlow/instance/")
@Api(value = "工作流流程实例接口", tags = "工作流流程实例接口API")
public class WorkFlowInstanceController {

    @Autowired
    private WorkFlowInstanceService instanceService;

    @RequestMapping(value = "v1/executeCmd", method = RequestMethod.POST)
    @ApiOperation(value = "指定流程实例相关命令", notes = "指定流程实例相关命令", httpMethod = "POST", code = 9999)
    public R v1ExecuteCmd(@RequestBody WorkFlowInstanceVo instanceVo) {
        Object resultObj = instanceService.executeCmd(instanceVo);
        return R.ok().data(resultObj);
    }
}
