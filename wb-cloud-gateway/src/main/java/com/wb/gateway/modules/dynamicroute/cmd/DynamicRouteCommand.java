package com.wb.gateway.modules.dynamicroute.cmd;

import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVo;

/**
 * @ClassName: DynamicRouteCommand
 * @Package: com.wb.gateway.modules.dynamicroute.cmd
 * @Description: the dynamic route command
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public interface DynamicRouteCommand<T> {

    /**
     * execute command
     *
     * @param routeVo the route vo
     * @return the execute command result
     */
    T execute(DynamicRouteVo routeVo);
}
