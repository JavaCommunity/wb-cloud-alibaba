package com.wb.dynamic.datasource.component.aop;

import com.wb.dynamic.datasource.component.exception.DynamicDataSourceException;
import org.springframework.aop.framework.AopContext;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: AopBeanFactory
 * @Package: com.wb.dynamic.datasource.component.aop
 * @Description: the aop bean factory
 * @Author：[bo.wang]
 * @Date: 2021/4/14
 * @Version: 1.0
 */
public class AopBeanFactory {

    /**
     * get bean with the specified cls
     *
     * @param cls the cls
     * @param <T>
     * @return the bean
     */
    public static <T> T getBean(Class<T> cls) {
        if (ObjectUtils.isEmpty(cls)) {
            throw new DynamicDataSourceException("'cls' must not be null！");
        }
        return (T) AopContext.currentProxy();
    }
}
