package com.wb.dynamic.datasource.example.entity;

import java.io.Serializable;

/**
 * @ClassName: UserEntity
 * @Package: com.wb.dynamic.datasource.example.entity
 * @Description: the user entity
 * @Author：[bo.wang]
 * @Date: 2021/2/4
 * @Version: 1.0
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -3506646040708277325L;

    //  the user name
    private String name;

    //  the age
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
