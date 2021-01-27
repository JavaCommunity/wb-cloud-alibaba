package com.wb.gateway.config;

import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Knife4jResourceProvider
 * @Package: com.wb.gateway.config
 * @Description: the knife4j resource provider
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@Primary
@Component
public class Knife4jResourceProvider implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;

    private final GatewayProperties gatewayProperties;

    public Knife4jResourceProvider(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
        this.routeLocator = routeLocator;
        this.gatewayProperties = gatewayProperties;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(route -> {
                    route.getPredicates().stream()
                            .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                            .forEach(predicateDefinition -> resources.add(swaggerResource(route.getId(),
                                    predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                            .replace("**", "v2/api-docs"))));
                });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
