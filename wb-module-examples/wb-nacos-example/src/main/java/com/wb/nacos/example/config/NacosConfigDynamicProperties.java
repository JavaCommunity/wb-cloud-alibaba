package com.wb.nacos.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: NacosConfigDynamicProperties
 * @Package: com.wb.nacos.example.config
 * @Description: the nacos config dynamic properties
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "user")
public class NacosConfigDynamicProperties {

    //  the user name
    private String name;

    //  the user age
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
