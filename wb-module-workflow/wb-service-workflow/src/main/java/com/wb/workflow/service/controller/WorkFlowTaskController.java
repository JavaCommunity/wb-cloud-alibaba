package com.wb.workflow.service.controller;

import com.wb.common.result.R;
import com.wb.workflow.core.service.WorkFlowTaskService;
import com.wb.workflow.core.vo.WorkFlowTaskVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: WorkFlowTaskController
 * @Package: com.wb.workflow.service.controller
 * @Description: the work flow task controller
 * @Author：[bo.wang]
 * @Date: 2021/3/1
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "workFlow/task/")
@Api(value = "工作流流程任务接口", tags = "工作流流程任务接口API")
public class WorkFlowTaskController {

    @Autowired
    private WorkFlowTaskService taskService;

    @RequestMapping(value = "v1/executeCmd", method = RequestMethod.POST)
    @ApiOperation(value = "执行流程任务相关命令", notes = "执行流程任务相关命令", httpMethod = "POST", code = 9999)
    public R v1ExecuteCmd(@RequestBody WorkFlowTaskVo taskVo) {
        Object resultObj = taskService.executeCmd(taskVo);
        return R.ok().data(resultObj);
    }
}
