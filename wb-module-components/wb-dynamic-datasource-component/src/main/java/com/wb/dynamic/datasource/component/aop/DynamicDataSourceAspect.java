package com.wb.dynamic.datasource.component.aop;

import com.wb.dynamic.datasource.component.annotation.DynamicDataSource;
import com.wb.dynamic.datasource.component.config.DynamicDataSourceContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;

/**
 * @ClassName: DynamicDataSourceAspect
 * @Package: com.wb.dynamic.datasource.component.aop
 * @Description: the dynamic datasource aspect
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DynamicDataSourceAspect {

    /**
     * the dynamic datasource point cut
     */
    @Pointcut("@annotation(com.wb.dynamic.datasource.component.annotation.DynamicDataSource) " +
            "|| @within(com.wb.dynamic.datasource.component.annotation.DynamicDataSource)")
    public void dynamicDataSourcePointCut() {
    }

    /**
     * the dynamic datasource around
     *
     * @param point the point
     * @return the current datasource
     * @throws Throwable
     */
    @Around("dynamicDataSourcePointCut()")
    public Object dynamicDataSourceAround(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class targetClass = point.getTarget().getClass();

        DynamicDataSource targetDataSource = (DynamicDataSource) targetClass.getAnnotation(DynamicDataSource.class);
        if (ObjectUtils.isEmpty(targetDataSource)) {
            Method mostSpecificMethod = AopUtils.getMostSpecificMethod(signature.getMethod(), targetClass);
            targetDataSource = mostSpecificMethod.getAnnotation(DynamicDataSource.class);
        }
        if (!ObjectUtils.isEmpty(targetDataSource)) {
            String value = targetDataSource.value();
            DynamicDataSourceContext.setCurrentDataSource(value);
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSourceContext.removeCurrentDataSource();
        }
    }
}
