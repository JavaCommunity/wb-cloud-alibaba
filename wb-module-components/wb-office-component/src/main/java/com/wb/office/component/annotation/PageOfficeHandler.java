package com.wb.office.component.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: PageOfficeHandler
 * @Package: com.wb.office.component.annotation
 * @Description: the pageOffice handler
 * @Author：[bo.wang]
 * @Date: 2021/2/9
 * @Version: 1.0
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PageOfficeHandler {

    //  the value,default ""
    String value() default "";
}
