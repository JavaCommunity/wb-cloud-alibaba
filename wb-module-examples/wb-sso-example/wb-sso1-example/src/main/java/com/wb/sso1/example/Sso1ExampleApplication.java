package com.wb.sso1.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @ClassName: Sso1ExampleApplication
 * @Package: com.wb.sso1.example
 * @Description: the sso1 example application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@EnableOAuth2Sso
@SpringBootApplication
public class Sso1ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sso1ExampleApplication.class);
    }
}
