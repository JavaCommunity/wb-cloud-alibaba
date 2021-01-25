package com.wb.seata.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: SeataStorageServiceApplication
 * @Package: com.wb.seata.example
 * @Description: the seata storage service application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.wb.seata.example.repository")
public class SeataStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceApplication.class);
    }
}
