package com.wb.sms.example;

import com.wb.sms.component.annotation.EnableSms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: SmsExampleApplication
 * @Package: com.wb.sms.example
 * @Description: the sms example application entry
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
@EnableSms
@SpringBootApplication
public class SmsExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsExampleApplication.class, args);
    }
}
