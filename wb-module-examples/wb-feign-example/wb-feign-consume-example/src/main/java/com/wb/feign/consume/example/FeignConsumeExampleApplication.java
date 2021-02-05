package com.wb.feign.consume.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: FeignConsumeExampleApplication
 * @Package: com.wb.feign.consume.example
 * @Description: the feign consume example application entry
 * @Author：[bo.wang]
 * @Date: 2021/2/5
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wb.feign.consume.example.feign")
public class FeignConsumeExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumeExampleApplication.class, args);
    }
}
