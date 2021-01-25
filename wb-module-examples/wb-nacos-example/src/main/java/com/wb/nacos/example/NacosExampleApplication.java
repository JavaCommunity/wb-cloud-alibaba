package com.wb.nacos.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: NacosExampleApplication
 * @Package: com.wb.nacos.example
 * @Description: the nacos example application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosExampleApplication.class);
    }
}
