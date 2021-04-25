package com.wb.oauth.service.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: ValidateCodeFilter
 * @Package: com.wb.oauth.service.filter
 * @Description: 验证码过滤器
 * @Author：[bo.wang]
 * @Date: 2021/4/25
 * @Version: 1.0
 */
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }
}
