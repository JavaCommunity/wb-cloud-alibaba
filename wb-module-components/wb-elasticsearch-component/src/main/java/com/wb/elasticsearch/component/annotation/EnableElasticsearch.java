package com.wb.elasticsearch.component.annotation;

import com.wb.elasticsearch.component.config.ElasticsearchAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableElasticsearch
 * @Package: com.wb.elasticsearch.component.annotation
 * @Description: the enable elasticsearch
 * @Author：[bo.wang]
 * @Date: 2021/3/10
 * @Version: 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({ElasticsearchAutoConfiguration.class})
public @interface EnableElasticsearch {

    //  the value
    String value() default "";
}
