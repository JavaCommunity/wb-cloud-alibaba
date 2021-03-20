package com.wb.gateway.modules.dynamicroute.cmd;

import com.wb.gateway.modules.dynamicroute.utils.DynamicRouteUtils;
import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @ClassName: DynamicRouteSaveCmd
 * @Package: com.wb.gateway.modules.dynamicroute.cmd
 * @Description: the dynamic route save command
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Component
public class DynamicRouteSaveCmd extends DynamicRouteGenericCmd<Void> {

    @Autowired
    private RouteDefinitionWriter definitionWriter;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public Void execute(DynamicRouteVo routeVo) {
        RouteDefinition routeDefinition = DynamicRouteUtils.getDefinition(routeVo);
        definitionWriter.save(Mono.just(routeDefinition)).subscribe();
        super.refresh(eventPublisher);
        return null;
    }
}
