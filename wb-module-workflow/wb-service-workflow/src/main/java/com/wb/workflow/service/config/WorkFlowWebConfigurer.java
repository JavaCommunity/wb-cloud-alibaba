package com.wb.workflow.service.config;

import com.wb.workflow.service.interceptor.WorkFlowHandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: WorkFlowWebConfigurer
 * @Package: com.wb.workflow.service.config
 * @Description: the work flow web config
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
@Component
public class WorkFlowWebConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/modeler/**")
                .addResourceLocations("classpath:/templates/modeler/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WorkFlowHandlerInterceptor())
                .addPathPatterns("/**");
    }
}
