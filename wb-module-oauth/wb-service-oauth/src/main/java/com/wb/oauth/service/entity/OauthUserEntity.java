package com.wb.oauth.service.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @ClassName: OauthUserEntity
 * @Package: com.wb.oauth.service.entity
 * @Description: 认证中心用户信息实体类
 * @Author：[bo.wang]
 * @Date: 2021/4/25
 * @Version: 1.0
 */
public class OauthUserEntity extends SysUserEntity implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.getAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
