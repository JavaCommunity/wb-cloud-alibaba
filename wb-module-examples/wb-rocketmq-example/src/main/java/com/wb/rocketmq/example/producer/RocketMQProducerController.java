package com.wb.rocketmq.example.producer;

import com.wb.common.result.R;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: RocketMQProducerController
 * @Package: com.wb.rocketmq.example.producer
 * @Description: the rocket mq producer controller
 * @Author：[bo.wang]
 * @Date: 2021/4/6
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "rocketMQProducer/")
public class RocketMQProducerController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping(value = "syncSend", method = RequestMethod.GET)
    public R<SendResult> syncSend() {
        SendResult sendResult = rocketMQTemplate.syncSend("string-topic", "Hello, World!");
        return R.ok().data(sendResult);
    }

    @RequestMapping(value = "asyncSend", method = RequestMethod.GET)
    public R<SendResult> asyncSend() {
        rocketMQTemplate.asyncSend("string-topic", "Hello, World!", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("[RocketMQ] Async Success Result:" + sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("[RocketMQ] Async Exception Result:" + throwable);
            }
        });
        return R.ok();
    }
}
