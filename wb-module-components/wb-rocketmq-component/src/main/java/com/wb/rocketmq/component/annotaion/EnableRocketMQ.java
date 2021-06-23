package com.wb.rocketmq.component.annotaion;

import com.wb.rocketmq.component.config.RocketMQAutoConfiguration;
import com.wb.rocketmq.component.config.RocketMQAutoConfigurationV2;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableRocketMQ
 * @Package: com.wb.rocketmq.component.annotaion
 * @Description: the enable rocket mq
 * @Author：[bo.wang]
 * @Date: 2021/4/6
 * @Version: 1.0
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Import({RocketMQAutoConfiguration.class})
@Import({RocketMQAutoConfigurationV2.class})
public @interface EnableRocketMQ {

    //  the value,default ""
    String value() default "";
}
