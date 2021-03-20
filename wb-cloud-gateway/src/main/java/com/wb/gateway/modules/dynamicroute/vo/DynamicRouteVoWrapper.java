package com.wb.gateway.modules.dynamicroute.vo;

import java.io.Serializable;

/**
 * @ClassName: DynamicRouteWrapperVo
 * @Package: com.wb.gateway.modules.dynamicroute.vo
 * @Description: the dynamic route vo wrapper
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public class DynamicRouteVoWrapper implements Serializable {

    //  the action
    private String action;

    //  the dynamic route vo
    private DynamicRouteVo routeVo;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public DynamicRouteVo getRouteVo() {
        return routeVo;
    }

    public void setRouteVo(DynamicRouteVo routeVo) {
        this.routeVo = routeVo;
    }
}
