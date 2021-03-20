package com.wb.gateway.modules.dynamicroute.cmd;

import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

/**
 * @ClassName: DynamicRouteDeleteCmd
 * @Package: com.wb.gateway.modules.dynamicroute.cmd
 * @Description: teh dynamic route delete command
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Component
public class DynamicRouteDeleteCmd extends DynamicRouteGenericCmd<Void> {

    @Autowired
    private RouteDefinitionWriter definitionWriter;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public Void execute(DynamicRouteVo routeVo) {
        String routeId = routeVo.getId();
        Assert.hasText(routeId, "'routeId' must not be null！");
        definitionWriter.delete(Mono.just(routeId)).subscribe();
        super.refresh(eventPublisher);
        return null;
    }
}
