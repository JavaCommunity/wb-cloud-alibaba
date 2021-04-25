package com.wb.oauth.service.config;

import com.alibaba.fastjson.JSONObject;
import com.wb.common.result.R;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.*;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: AuthenticationHandlerConfig
 * @Package: com.wb.oauth.service.config
 * @Description: 认证处理器配置
 * @Author：[bo.wang]
 * @Date: 2021/4/25
 * @Version: 1.0
 */
@Configuration
public class AuthenticationHandlerConfig {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(AuthenticationHandlerConfig.class);

    /**
     * 成功处理器
     *
     * @return
     */
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }

    /**
     * 失败处理器
     *
     * @return
     */
    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {
        return new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException e) throws IOException, ServletException {
                R failureResult = R.error(e.getMessage());
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSONObject.toJSONString(failureResult));
                response.getWriter().flush();
                response.getWriter().close();
            }
        };
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "*");
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpStatus.OK.value());
                response.getWriter().write(
                        JSONObject.toJSONString(R.error(String.valueOf(HttpStatus.UNAUTHORIZED.value()), e.getMessage()))
                );
            }
        };
    }

    @Bean
    public WebResponseExceptionTranslator webResponseExceptionTranslator() {
        return new WebResponseExceptionTranslator() {
            @Override
            public ResponseEntity translate(Exception e) throws Exception {
                ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
                log.error("[Oauth2 Starter] Service Error,ErrMsg:{}", e.getMessage());
                String message = "认证失败，请稍后重试！";
                if (e instanceof UnsupportedGrantTypeException) {
                    message = "不支持该认证类型";
                    return builder.body(R.error(message));
                }
                if (e instanceof InvalidTokenException
                        && StringUtils.containsIgnoreCase(e.getMessage(), "Invalid refresh token (expired)")) {
                    message = "刷新令牌已过期，请重新登录";
                    return builder.body(R.error(message));
                }
                if (e instanceof InvalidScopeException) {
                    message = "不是有效的scope值";
                    return builder.body(R.error(message));
                }
                if (e instanceof RedirectMismatchException) {
                    message = "redirect_uri值不正确";
                    return builder.body(R.error(message));
                }
                if (e instanceof BadClientCredentialsException) {
                    message = "client值不合法";
                    return builder.body(R.error(message));
                }
                if (e instanceof UnsupportedResponseTypeException) {
                    String code = StringUtils.substringBetween(e.getMessage(), "[", "]");
                    message = code + "不是合法的response_type值";
                    return builder.body(R.error(message));
                }
                if (e instanceof InvalidGrantException) {
                    String errMsg = e.getMessage();
                    switch (errMsg) {
                        case "Invalid refresh token":
                            return builder.body(R.error(AuthorizationErrorEnum.INVALID_TOKEN.getErrMsg()));
                        case "Invalid authorization code":
                            return builder.body(R.error(AuthorizationErrorEnum.INVALID_CODE.getErrMsg()));
                        default:
                            return builder.body(R.error(e.getMessage()));
                    }
                }
                return builder.body(R.error(message));
            }
        };
    }
}
