package com.wb.sign.example;

import com.wb.sign.component.annotation.EnableSign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: SignExampleApplication
 * @Package: com.wb.sign.example
 * @Description: the sign example application entry
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@EnableSign
@SpringBootApplication
public class SignExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignExampleApplication.class);
    }
}
