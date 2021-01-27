package com.wb.oauth.service.service.impl;

import com.wb.oauth.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Package: com.wb.oauth.service.service.impl
 * @Description: the user service impl
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //  TODO 增加数据库查询
        String encode = passwordEncoder.encode("123456");
        return new User(userName, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
