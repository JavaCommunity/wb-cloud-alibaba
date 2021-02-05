package com.wb.feign.consume.example.controller;

import com.wb.common.result.R;
import com.wb.feign.consume.example.feign.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IndexController
 * @Package: com.wb.feign.consume.example.controller
 * @Description: the index controller
 * @Author：[bo.wang]
 * @Date: 2021/2/5
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "index/")
public class IndexController {

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping(value = "findUserById")
    public R findUserById(@RequestParam(value = "userId") String userId) {
        return userFeignService.findByUserId(userId);
    }
}
