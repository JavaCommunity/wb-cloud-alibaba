package com.wb.admin.service.interceptor;

import com.wb.admin.service.config.AdminContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: TokenInterceptor
 * @Package: com.wb.admin.service.interceptor
 * @Description: token 拦截器
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AdminContextHolder.clear();
    }
}
