package com.wb.feign.provider.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: FeignProviderExampleApplication
 * @Package: com.wb.feign.provider.example
 * @Description: the feign provider example application entry
 * @Author：[bo.wang]
 * @Date: 2021/2/5
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FeignProviderExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignProviderExampleApplication.class, args);
    }
}
