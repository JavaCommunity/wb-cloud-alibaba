package com.wb.nacos.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ClassName: NacosConfigDynamicValueController
 * @Package: com.wb.nacos.example.controller
 * @Description: the nacos config dynamic value controller
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@RefreshScope
@RestController
@RequestMapping("/nacos/config/dynamic/")
public class NacosConfigDynamicValueController {

    //  the user name
    @Value("${user.name}")
    private String userName;

    //  the user age
    @Value("${user.age}")
    private String userAge;

    /**
     * get user info
     *
     * @return user info
     */
    @RequestMapping(value = "/getValue", method = RequestMethod.GET)
    public Object getValue() {
        return new HashMap<String, Object>(2) {{
            put("userName", userName);
            put("userAge", userAge);
        }};
    }
}
