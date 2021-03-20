package com.wb.admin.service.modules.route.controller;

import com.wb.admin.service.modules.route.service.SysRouteDefinitionService;
import com.wb.admin.service.modules.route.vo.SysRouteDefinitionVo;
import com.wb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SysRouteDefinitionController
 * @Package: com.wb.admin.service.modules.route
 * @Description: the sys route definition controller
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "sys/route/definition/")
@Api(value = "系统动态路由定义接口", tags = "系统动态路由定义接口API")
public class SysRouteDefinitionController {

    @Autowired
    private SysRouteDefinitionService definitionService;

    @RequestMapping(value = "v1/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存系统动态路由定义", notes = "保存系统动态路由定义", httpMethod = "POST", code = 9999)
    public R v1Save(@RequestBody SysRouteDefinitionVo definitionVo) {
        definitionService.save(definitionVo);
        return R.ok();
    }
}
