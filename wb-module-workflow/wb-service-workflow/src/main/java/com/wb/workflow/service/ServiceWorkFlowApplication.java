package com.wb.workflow.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: ServiceWorkFlowApplication
 * @Package: com.wb.workflow.service
 * @Description: the service workFlow application entry
 * @Author：[bo.wang]
 * @Date: 2021/2/10
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages =
        "com.wb.workflow.core.repository"
)
@ComponentScan(basePackages = {
        "com.wb.flowable.ext.api",
        "com.wb.workflow.core",
        "com.wb.workflow.service"
})
public class ServiceWorkFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceWorkFlowApplication.class, args);
    }
}
