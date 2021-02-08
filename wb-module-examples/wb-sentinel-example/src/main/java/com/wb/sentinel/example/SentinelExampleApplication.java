package com.wb.sentinel.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: SentinelExampleApplication
 * @Package: com.wb.sentinel.example
 * @Description: the sentinel example application entry
 * @Author：[bo.wang]
 * @Date: 2021/2/7
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelExampleApplication.class, args);
    }
}
