package com.wb.seata.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: SeataOrderServiceApplication
 * @Package: com.wb.seata.example
 * @Description: the seata order service application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/23
 * @Version: 1.0
 */
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.wb.seata.example.repository"})
@EnableFeignClients(basePackages = "com.wb.seata.example.feign")
@SpringBootApplication(scanBasePackages = {"com.wb.seata.example"}, exclude = DataSourceAutoConfiguration.class)
public class SeataOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServiceApplication.class, args);
    }
}
