package com.wb.workflow.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: WorkFlowStencilsetController
 * @Package: com.wb.workflow.service.controller
 * @Description: the work flow stencilset controller
 * @Author：[bo.wang]
 * @Date: 2021/2/19
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "workFlow/stencilset/")
@Api(value = "工作流程汉化资源接口", tags = "工作流程汉化资源接口API")
public class WorkFlowStencilsetController {

    //  the stencilset json name
    private static final String STENCILSET_JSON_NAME = "stencilset.json";

    @ApiOperation(value = "获取汉化资源信息", notes = "获取汉化资源信息", httpMethod = "GET", code = 9999)
    @RequestMapping(value = "v1/getStencilset", method = RequestMethod.GET)
    public String v1GetStencilset() throws IOException {
        InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream(STENCILSET_JSON_NAME);
        String stencilsetStr = IOUtils.toString(stencilsetStream, "utf-8");
        return stencilsetStr;
    }
}
