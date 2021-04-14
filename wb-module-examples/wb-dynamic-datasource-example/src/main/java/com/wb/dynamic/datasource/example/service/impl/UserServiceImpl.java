package com.wb.dynamic.datasource.example.service.impl;

import com.wb.dynamic.datasource.component.annotation.DynamicDataSource;
import com.wb.dynamic.datasource.component.aop.AopBeanFactory;
import com.wb.dynamic.datasource.example.entity.UserEntity;
import com.wb.dynamic.datasource.example.repository.UserMapper;
import com.wb.dynamic.datasource.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Package: com.wb.dynamic.datasource.example.service.impl
 * @Description: the user service impl
 * @Author：[bo.wang]
 * @Date: 2021/2/4
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity queryForDd1(String userId) {
        return userMapper.queryForDd1(userId);
    }

    @Override
    @DynamicDataSource("second")
    public UserEntity queryForDd2(String userId) {
        UserService bean = AopBeanFactory.getBean(UserService.class);
        UserEntity userEntity = bean.queryForDd3(userId);
        return userMapper.queryForDd2(userId);
    }

    @Override
    @DynamicDataSource("third")
    public UserEntity queryForDd3(String userId) {
        return userMapper.queryForDd2(userId);
    }
}
