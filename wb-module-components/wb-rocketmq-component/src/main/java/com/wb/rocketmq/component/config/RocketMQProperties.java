package com.wb.rocketmq.component.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: RockerMQProperties
 * @Package: com.wb.rocketmq.component.config
 * @Description: the rocket mq properties
 * @Author：[bo.wang]
 * @Date: 2021/4/6
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wb-cloud.rocketmq")
public class RocketMQProperties extends org.apache.rocketmq.spring.autoconfigure.RocketMQProperties {
}
