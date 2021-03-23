package com.wb.sign.component.annotation;

import com.wb.sign.component.config.SignAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableSign
 * @Package: com.wb.sign.component.annotation
 * @Description: the enable sign
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SignAutoConfiguration.class})
public @interface EnableSign {

    //  the default value
    String value() default "";
}
