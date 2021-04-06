package com.wb.rocketmq.example.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RockerMQConsumerListener
 * @Package: com.wb.rocketmq.example.consumer
 * @Description: the rocket mq consumer listener
 * @Author：[bo.wang]
 * @Date: 2021/4/6
 * @Version: 1.0
 */
public class RockerMQConsumerListener {

    /**
     * the string consumer
     */
    @Component
    @RocketMQMessageListener(topic = "string-topic", consumerGroup = "string_consumer")
    static class StringConsumer implements RocketMQListener<String> {
        @Override
        public void onMessage(String message) {
            System.out.println("[StringConsumer] Message：" + message);
        }
    }
}
