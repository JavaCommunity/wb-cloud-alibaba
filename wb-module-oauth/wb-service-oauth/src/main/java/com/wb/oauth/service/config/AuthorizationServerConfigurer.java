package com.wb.oauth.service.config;

import com.wb.oauth.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @ClassName: AuthorizationServerConfigurer
 * @Package: com.wb.oauth.service.config
 * @Description: the authorization server config
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@Configuration
@EnableAuthorizationServer
@DependsOn({"tokenStoreHandler"})
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetails;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // TODO 增加Redis存储
//        clients.inMemory()
//                .withClient("client")
//                .secret(passwordEncoder.encode("123456"))
//                // .redirectUris("http://www.baidu.com")
//                .redirectUris("http://localhost:7004/login", "http://localhost:7005/login")
//                .scopes("all")
//                .authorizedGrantTypes("authorization_code", "password");
        clients.withClientDetails(clientDetails);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }
}
