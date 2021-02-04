package com.wb.dynamic.datasource.component.annotation;

import com.wb.dynamic.datasource.component.config.DynamicDataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableDynamicDataSource
 * @Package: com.wb.dynamic.datasource.component.annotation
 * @Description: the enable dynamic datasource
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(DynamicDataSourceAutoConfiguration.class)
public @interface EnableDynamicDataSource {
}
