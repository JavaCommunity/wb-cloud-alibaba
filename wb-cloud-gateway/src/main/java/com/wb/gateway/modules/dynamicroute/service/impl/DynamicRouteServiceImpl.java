package com.wb.gateway.modules.dynamicroute.service.impl;

import com.wb.gateway.exception.GatewayServiceException;
import com.wb.gateway.modules.dynamicroute.cmd.DynamicRouteResolver;
import com.wb.gateway.modules.dynamicroute.service.DynamicRouteService;
import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DynamicRouteServiceImpl
 * @Package: com.wb.gateway.modules.dynamicroute.service.impl
 * @Description: the dynamic route service impl
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Service
public class DynamicRouteServiceImpl implements DynamicRouteService {

    @Autowired
    private DynamicRouteResolver routeResolver;

    @Override
    public Object refresh(DynamicRouteVoWrapper routeVoWrapper) {
        String action = routeVoWrapper.getAction();
        boolean support = routeResolver.isSupport(action);
        if (!support) {
            throw new GatewayServiceException("not support action！");
        }
        return routeResolver.resolverCmdInvoke(routeVoWrapper.getRouteVo(), action);
    }
}
