package com.wb.oauth.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: OauthServiceApplication
 * @Package: com.wb.oauth.service
 * @Description: the oauth service application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/26
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.wb.oauth.service.mapper")
public class OauthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServiceApplication.class);
    }
}
