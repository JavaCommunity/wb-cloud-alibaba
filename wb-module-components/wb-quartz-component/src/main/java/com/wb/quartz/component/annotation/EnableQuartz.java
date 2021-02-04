package com.wb.quartz.component.annotation;

import com.wb.quartz.component.config.QuartzAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableQuartz
 * @Package: com.wb.quartz.component.annotation
 * @Description: the enable quartz
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(QuartzAutoConfiguration.class)
public @interface EnableQuartz {

    String value() default "";
}
