package com.wb.oauth.service.config;

import com.wb.oauth.service.filter.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ClassName: WebSecurityConfigurer
 * @Package: com.wb.oauth.service.config
 * @Description: the web security configurer
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    //  需要排除的url
    private static final String[] IGNORING_URL = new String[]{
            "/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
            "swagger-ui.html", "/webjars/**", "/doc.html", "/login.html"
    };

    @Autowired
    private ValidateCodeFilter codeFilter;

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(IGNORING_URL);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(codeFilter, UsernamePasswordAuthenticationFilter.class)
                .requestMatchers()
                .antMatchers(Oauth2EndpointConstants.OAUTH_ALL, Oauth2EndpointConstants.LOGIN)
                .and()
                .authorizeRequests()
                .antMatchers(Oauth2EndpointConstants.OAUTH_ALL).authenticated()
                .and()
                .formLogin()
                .loginPage(Oauth2EndpointConstants.LOGIN)
                .loginProcessingUrl(Oauth2EndpointConstants.LOGIN)
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .permitAll()
                .and().csrf().disable()
                .httpBasic().disable();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
