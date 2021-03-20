package com.wb.gateway.modules.dynamicroute.cmd;

import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVo;

/**
 * @ClassName: DynamicRouteResolver
 * @Package: com.wb.gateway.modules.dynamicroute.cmd
 * @Description: teh dynamic route resolver
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public interface DynamicRouteResolver {

    /**
     * check is support with the specified action.
     *
     * @param action the action
     * @return <tt>true<tt/> if support
     */
    boolean isSupport(String action);

    /**
     * resolver cmd invoke with the specified route vo and action.
     *
     * @param routeVo the route vo
     * @param action  the action
     * @return the execute cmd result
     */
    Object resolverCmdInvoke(DynamicRouteVo routeVo, String action);
}
