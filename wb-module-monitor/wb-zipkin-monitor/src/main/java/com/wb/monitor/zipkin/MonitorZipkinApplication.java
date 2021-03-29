package com.wb.monitor.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @ClassName: MonitorZipkinApplication
 * @Package: com.wb.monitor.zipkin
 * @Description: the monitor zipkin application entry
 * @Author：[bo.wang]
 * @Date: 2021/3/24
 * @Version: 1.0
 */
@EnableZipkinServer
@SpringBootApplication
@EnableDiscoveryClient
public class MonitorZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorZipkinApplication.class, args);
    }
}
