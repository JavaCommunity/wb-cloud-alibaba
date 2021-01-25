package com.wb.nacos.example.controller;

import com.wb.nacos.example.config.NacosConfigDynamicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ClassName: NacosConfigDynamicPropertiesController
 * @Package: com.wb.nacos.example.controller
 * @Description: the nacos config dynamic properties controller
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@RestController
@RequestMapping("/nacos/config/dynamic/")
@EnableConfigurationProperties(value = {NacosConfigDynamicProperties.class})
public class NacosConfigDynamicPropertiesController {

    @Autowired
    private NacosConfigDynamicProperties nacosDynamicProperties;

    /**
     * get user info
     *
     * @return the user info
     */
    @RequestMapping(value = "/getProperties", method = RequestMethod.GET)
    public Object getValue() {
        return new HashMap<String, Object>(2) {{
            put("userName", nacosDynamicProperties.getName());
            put("userAge", nacosDynamicProperties.getAge());
        }};
    }
}
