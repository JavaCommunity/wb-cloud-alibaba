package com.wb.dynamic.datasource.example;

import com.wb.dynamic.datasource.component.annotation.EnableDynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: DynamicDatasourceExampleApplication
 * @Package: com.wb.dynamic.datasource.example
 * @Description: the dynamic datasource example application entry
 * @Author：[bo.wang]
 * @Date: 2021/2/4
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDynamicDataSource
@MapperScan(basePackages = "com.wb.dynamic.datasource.example.repository")
public class DynamicDatasourceExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceExampleApplication.class, args);
    }
}
