package com.wb.gateway.modules.dynamicroute.cmd;

import com.wb.gateway.modules.dynamicroute.config.DynamicRouteActionEnum;
import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DynamicRouteUpdateCmd
 * @Package: com.wb.gateway.modules.dynamicroute.cmd
 * @Description: the dynamic route update command
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Component
public class DynamicRouteUpdateCmd extends DynamicRouteGenericCmd<Void> {

    @Autowired
    private DynamicRouteResolver routeResolver;

    @Override
    public Void execute(DynamicRouteVo routeVo) {
        routeResolver.resolverCmdInvoke(routeVo, DynamicRouteActionEnum.DELETE.name());
        routeResolver.resolverCmdInvoke(routeVo, DynamicRouteActionEnum.SAVE.name());
        return null;
    }
}
