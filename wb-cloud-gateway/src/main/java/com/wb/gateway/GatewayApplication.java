package com.wb.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GatewayApplication
 * @Package: com.wb.gateway
 * @Description: the gateway application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}
