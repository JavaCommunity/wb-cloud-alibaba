package com.wb.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: ServiceLogApplication
 * @Package: com.wb.log
 * @Description: the service log application entry
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.wb.log.repository"})
public class ServiceLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceLogApplication.class, args);
    }
}
