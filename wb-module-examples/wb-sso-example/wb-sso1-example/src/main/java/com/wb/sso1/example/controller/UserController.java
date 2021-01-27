package com.wb.sso1.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Package: com.wb.sso1.example.controller
 * @Description: the user controller
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    /**
     * get current user info
     *
     * @return the user info
     */
    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
