package com.wb.office.example;

import com.wb.office.component.annotation.EnableOffice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: OfficeExampleApplication
 * @Package: com.wb.office.example
 * @Description: the office example application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@EnableOffice
@SpringBootApplication
public class OfficeExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficeExampleApplication.class);
    }
}
