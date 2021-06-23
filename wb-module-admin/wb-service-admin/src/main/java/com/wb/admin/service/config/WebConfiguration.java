package com.wb.admin.service.config;

import com.wb.admin.service.interceptor.TokenInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName: WebConfiguration
 * @Package: com.wb.admin.service.config
 * @Description: web配置
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
@Component
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
