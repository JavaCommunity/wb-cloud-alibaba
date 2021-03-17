package com.wb.sms.component.annotation;

import com.wb.sms.component.config.SmsAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableSms
 * @Package: com.wb.sms.component.annotation
 * @Description: the enable sms
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SmsAutoConfiguration.class})
public @interface EnableSms {

    //  the value
    String value() default "";
}
