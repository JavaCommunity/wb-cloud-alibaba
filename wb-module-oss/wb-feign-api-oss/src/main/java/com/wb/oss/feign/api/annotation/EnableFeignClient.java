package com.wb.oss.feign.api.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/**
 * @ClassName: EnableFeignClient
 * @Package: com.wb.oss.feign.api.annotation
 * @Description: the enable feign client
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableFeignClients(basePackages = "com.wb.oss.feign.api")
public @interface EnableFeignClient {

    //  the value
    String[] value() default {};
}
