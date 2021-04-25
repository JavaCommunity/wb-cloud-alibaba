package com.wb.oauth.service.service.impl;

import com.wb.oauth.service.config.AuthorizationErrorEnum;
import com.wb.oauth.service.entity.OauthUserEntity;
import com.wb.oauth.service.mapper.UserMapper;
import com.wb.oauth.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

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
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Assert.hasText(userName, "账号不能为空！");
        OauthUserEntity userEntity = userMapper.queryForAccount(userName);

        if (ObjectUtils.isEmpty(userEntity)) {
            throw new UsernameNotFoundException(AuthorizationErrorEnum.USER_NOT_FOUND.getErrMsg());
        }
        if ("0".equalsIgnoreCase(userEntity.getStatus())) {
            throw new UsernameNotFoundException(AuthorizationErrorEnum.USER_DRAFT.getErrMsg());
        }
        if ("2".equalsIgnoreCase(userEntity.getStatus())) {
            throw new UsernameNotFoundException(AuthorizationErrorEnum.USER_LOCK.getErrMsg());
        }
        if ("3".equalsIgnoreCase(userEntity.getStatus())) {
            throw new UsernameNotFoundException(AuthorizationErrorEnum.USER_DISABLE.getErrMsg());
        }
        return userEntity;
    }
}
