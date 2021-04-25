package com.wb.oauth.service.config;

/**
 * @ClassName: Oauth2EndpointConstants
 * @Package: com.wb.oauth.service.config
 * @Description: oauth2 端点常量
 * @Author：[bo.wang]
 * @Date: 2021/4/25
 * @Version: 1.0
 */
public interface Oauth2EndpointConstants {

    String ALL = "/**";

    String OAUTH_ALL = "/oauth/**";

    String OAUTH_AUTHORIZE = "/oauth/authorize";

    String OAUTH_CHECK_TOKEN = "/oauth/check_token";

    String OAUTH_CONFIRM_ACCESS = "/oauth/confirm_access";

    String OAUTH_TOKEN = "/oauth/token";

    String OAUTH_TOKEN_KEY = "/oauth/token_key";

    String OAUTH_ERROR = "/oauth/error";

    String ACTUATOR_ALL = "/actuator/**";

    String LOGIN = "/login";
}
