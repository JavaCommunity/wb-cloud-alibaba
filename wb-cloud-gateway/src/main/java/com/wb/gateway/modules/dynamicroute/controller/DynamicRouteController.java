package com.wb.gateway.modules.dynamicroute.controller;

import com.alibaba.fastjson.JSONObject;
import com.wb.common.result.R;
import com.wb.gateway.modules.dynamicroute.service.DynamicRouteService;
import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVoWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DynamicRouteController
 * @Package: com.wb.gateway.controller
 * @Description: the dynamic route controller
 * @Author：[bo.wang]
 * @Date: 2021/3/19
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "dynamic/route/")
@Api(value = "动态路由接口", tags = "动态路由接口API")
public class DynamicRouteController {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DynamicRouteController.class);

    @Autowired
    private DynamicRouteService routeService;

    @PostMapping(value = "v1/refresh")
    @ApiOperation(value = "动态刷新路由", notes = "动态刷新路由", httpMethod = "POST", code = 9999)
    public R v1Refresh(@RequestBody DynamicRouteVoWrapper routeVoWrapper) {
        log.info("[Gateway Starter] Refresh Route,Args：{}", JSONObject.toJSON(routeVoWrapper));
        routeService.refresh(routeVoWrapper);
        return R.ok();
    }
}
