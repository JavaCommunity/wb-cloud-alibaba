package com.wb.dynamic.datasource.example.controller;

import com.wb.common.result.R;
import com.wb.dynamic.datasource.example.entity.UserEntity;
import com.wb.dynamic.datasource.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Package: com.wb.dynamic.datasource.example.controller
 * @Description: the user controller
 * @Author：[bo.wang]
 * @Date: 2021/2/4
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "queryForDd1")
    public R queryForDd1(@RequestParam(value = "userId") String userId) {
        UserEntity userEntity = userService.queryForDd1(userId);
        return R.ok().data(userEntity);
    }

    @GetMapping(value = "queryForDd2")
    public R queryForDd2(@RequestParam(value = "userId") String userId) {
        UserEntity userEntity = userService.queryForDd2(userId);
        return R.ok().data(userEntity);
    }
}
