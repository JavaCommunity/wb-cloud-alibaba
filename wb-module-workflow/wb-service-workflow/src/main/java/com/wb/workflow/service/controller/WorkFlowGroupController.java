package com.wb.workflow.service.controller;

import com.wb.common.result.R;
import com.wb.workflow.core.service.WorkFlowGroupService;
import com.wb.workflow.core.vo.WorkFlowGroupVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: WorkFlowGroupController
 * @Package: com.wb.workflow.service.controller
 * @Description: the work flow group controller
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "workFlow/group/")
@Api(value = "工作流流程分组接口", tags = "工作流流程分组接口API")
public class WorkFlowGroupController {

    @Autowired
    private WorkFlowGroupService groupService;

    @RequestMapping(value = "v1/executeCmd", method = RequestMethod.POST)
    @ApiOperation(value = "指定流程分组相关命令", notes = "指定流程分组相关命令", httpMethod = "POST", code = 9999)
    public R v1ExecuteCmd(@RequestBody WorkFlowGroupVo groupVo) {
        Object resultObj = groupService.executeCmd(groupVo);
        return R.ok().data(resultObj);
    }
}
