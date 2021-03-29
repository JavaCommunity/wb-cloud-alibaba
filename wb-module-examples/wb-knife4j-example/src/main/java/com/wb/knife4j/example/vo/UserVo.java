package com.wb.knife4j.example.vo;

import java.io.Serializable;

/**
 * @ClassName: UserVo
 * @Package: com.wb.knife4j.example.vo
 * @Description: the user vo
 * @Author：[bo.wang]
 * @Date: 2021/3/25
 * @Version: 1.0
 */
public class UserVo implements Serializable {

    //  the user name
    private String username;

    //  the user age
    private String age;

    //  the user sex
    private String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
