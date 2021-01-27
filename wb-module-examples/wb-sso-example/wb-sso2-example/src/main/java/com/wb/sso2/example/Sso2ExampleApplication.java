package com.wb.sso2.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @ClassName: Sso2ExampleApplication
 * @Package: com.wb.sso2.example
 * @Description: the sso2 example application entry
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@EnableOAuth2Sso
@SpringBootApplication
public class Sso2ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sso2ExampleApplication.class);
    }
}
