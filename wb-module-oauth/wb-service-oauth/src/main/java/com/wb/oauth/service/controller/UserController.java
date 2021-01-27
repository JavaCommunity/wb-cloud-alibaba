package com.wb.oauth.service.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Package: com.wb.oauth.service.controller
 * @Description: the user controller
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@RestController
@RequestMapping("user/")
public class UserController {

    /**
     * get current user info
     *
     * @param authentication the spring security authentication
     * @return the user info
     */
    @RequestMapping(value = "getCurrentUser", method = RequestMethod.GET)
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
