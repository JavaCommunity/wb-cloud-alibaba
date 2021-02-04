package com.wb.quartz.example;

import com.wb.quartz.component.annotation.EnableQuartz;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: QuartzExampleApplication
 * @Package: com.wb.quartz.example
 * @Description: the quartz example application entry
 * @Author：[bo.wang]
 * @Date: 2021/2/3
 * @Version: 1.0
 */
@EnableQuartz
@SpringBootApplication
public class QuartzExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzExampleApplication.class, args);
    }
}
