package com.wb.office.component.annotation;

import com.wb.office.component.config.OfficeAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableOffice
 * @Package: com.wb.office.component.annotation
 * @Description: the enable office
 * @Author：[bo.wang]
 * @Date: 2021/1/28
 * @Version: 1.0
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({OfficeAutoConfiguration.class})
public @interface EnableOffice {

    //  the value,default ""
    String value() default "";
}
