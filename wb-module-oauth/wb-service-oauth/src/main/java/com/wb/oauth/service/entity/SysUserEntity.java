package com.wb.oauth.service.entity;

import com.wb.common.base.entity.BaseEntity;

/**
 * @ClassName: SysUserEntity
 * @Package: com.wb.oauth.service.entity
 * @Description: the sys user entity
 * @Author：[bo.wang]
 * @Date: 2021/4/25
 * @Version: 1.0
 */
public class SysUserEntity extends BaseEntity {

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮件
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户状态 0:暂存  1:正常  2:锁定  3:禁用
     */
    private String status;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
