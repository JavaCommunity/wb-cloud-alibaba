package com.wb.gateway.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * @ClassName: Knife4jHeaderFilter
 * @Package: com.wb.gateway.config
 * @Description: the knife4j header filter
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@Component
public class Knife4jHeaderFilter extends AbstractGatewayFilterFactory {

    //  the header name
    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    //  the uri
    private static final String URI = "/v2/api-docs";

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, URI)) {
                return chain.filter(exchange);
            }
            String basePath = path.substring(0, path.lastIndexOf(URI));
            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }
}
