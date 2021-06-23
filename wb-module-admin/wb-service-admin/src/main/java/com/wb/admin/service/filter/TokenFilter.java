package com.wb.admin.service.filter;

import com.wb.admin.service.config.AdminContextHolder;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName: TokenFilter
 * @Package: com.wb.admin.service.filter
 * @Description: token过滤器
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
public class TokenFilter implements Filter {

    //  oath2 token header
    private static final String OATH2_TOKEN_HEADER = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String assessToken = req.getHeader(OATH2_TOKEN_HEADER);
        if (StringUtils.isEmpty(assessToken)) {
            assessToken = req.getParameter(OATH2_TOKEN_HEADER);
        }

        if (StringUtils.isEmpty(assessToken)) {
            //  TODO 获取当前登录用户信息
            AdminContextHolder.setToken(assessToken);
        }
    }
}
