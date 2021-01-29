package com.wb.oss.example;

import com.wb.oss.component.annotation.EnableOss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: OssExampleApplication
 * @Package: com.wb.oss.example
 * @Description: the oss example application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@EnableOss
@SpringBootApplication
public class OssExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssExampleApplication.class, args);
    }
}
