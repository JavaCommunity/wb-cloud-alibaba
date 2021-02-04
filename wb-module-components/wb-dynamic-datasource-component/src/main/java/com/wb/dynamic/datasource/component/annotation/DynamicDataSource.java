package com.wb.dynamic.datasource.component.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: DynamicDataSource
 * @Package: com.wb.dynamic.datasource.component.annotation
 * @Description: the dynamic datasource
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DynamicDataSource {

    String value() default "";
}
