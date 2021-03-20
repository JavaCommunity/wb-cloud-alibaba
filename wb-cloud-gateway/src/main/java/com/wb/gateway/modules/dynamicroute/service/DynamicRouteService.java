package com.wb.gateway.modules.dynamicroute.service;

import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVoWrapper;

/**
 * @ClassName: DynamicRouteService
 * @Package: com.wb.gateway.modules.dynamicroute.service
 * @Description: the dynamic route service
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public interface DynamicRouteService {

    /**
     * dynamic refresh route with the specified route vo wrapper
     *
     * @param routeVoWrapper the route vo wrapper
     * @return the object
     */
    Object refresh(DynamicRouteVoWrapper routeVoWrapper);
}
