package com.wb.rocketmq.example;

import com.wb.rocketmq.component.annotaion.EnableRocketMQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: RocketMQExampleApplication
 * @Package: com.wb.rocketmq.example
 * @Description: the rocket mq example application entry
 * @Author：[bo.wang]
 * @Date: 2021/4/6
 * @Version: 1.0
 */
@EnableRocketMQ
@SpringBootApplication
public class RocketMQExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMQExampleApplication.class, args);
    }
}
