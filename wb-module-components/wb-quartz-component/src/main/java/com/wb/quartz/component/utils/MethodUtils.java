package com.wb.quartz.component.utils;

import com.wb.common.utils.spring.SpringApplicationContextProvider;
import com.wb.quartz.component.vo.QuartzJobVo;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: MethodUtils
 * @Package: com.wb.quartz.component.utils
 * @Description: the method utils
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class MethodUtils {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(MethodUtils.class);

    /**
     * the method invoke
     *
     * @param jobVo            the job vo
     * @param executionContext the execution context
     */
    public static void invoke(final QuartzJobVo jobVo, final JobExecutionContext executionContext)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Assert.notNull(jobVo, "'jobVo' must not null！");
        log.info("[Quartz Starter] Start Execute Job:" + jobVo.getName());

        String beanId = jobVo.getBeanId();
        Object jobBean = null;
        try {
            jobBean = SpringApplicationContextProvider.getBean(beanId);
        } catch (Exception e) {
        }
        Class<?> jobResourceClass = null;
        String resourceClass = jobVo.getResourceClass();
        Assert.notNull(resourceClass, "'resourceClass' must not be null！");
        jobResourceClass = Class.forName(resourceClass);
        if (ObjectUtils.isEmpty(jobBean)) {
            jobBean = jobResourceClass.newInstance();
        }
        Assert.notNull(jobBean, "'jobBean' must not be null！");

        String methodName = jobVo.getMethodName();
        Method[] declaredMethods = jobResourceClass.getDeclaredMethods();
        List<Method> methodList = Arrays.stream(declaredMethods).filter((method -> {
            method.setAccessible(true);
            return method.getName().equals(methodName);
        })).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(methodList)) {
            log.error("[Quartz Starter] Job {} no execute method {}", jobVo.getName(), jobVo.getMethodName());
            return;
        }
        try {
            Method method = methodList.get(0);
            method.invoke(jobBean, executionContext);
        } catch (Exception e) {
            log.error("[Quartz Starter] Job {} execute method {} Error,ErrMsg:{}", e.getMessage(), jobVo.getName(), jobVo.getMethodName(), e.getMessage());
        }
    }
}
