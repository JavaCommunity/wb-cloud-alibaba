package com.wb.oss.component.annotation;

import com.wb.oss.component.config.OssAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableOss
 * @Package: com.wb.oss.component.annotation
 * @Description: the enable oss
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({OssAutoConfiguration.class})
public @interface EnableOss {

    //  the value,default ""
    String value() default "";
}
