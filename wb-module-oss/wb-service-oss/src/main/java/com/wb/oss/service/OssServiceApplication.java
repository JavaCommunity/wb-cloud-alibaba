package com.wb.oss.service;

import com.wb.oss.component.annotation.EnableOss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: OssServiceApplication
 * @Package: com.wb.oss.service
 * @Description: the oss service application entry
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@EnableOss
@EnableDiscoveryClient
@SpringBootApplication
public class OssServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssServiceApplication.class);
    }
}
