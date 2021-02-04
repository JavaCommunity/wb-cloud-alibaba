package com.wb.dynamic.datasource.example.service;

import com.wb.dynamic.datasource.example.entity.UserEntity;

/**
 * @ClassName: UserService
 * @Package: com.wb.dynamic.datasource.example.service
 * @Description: the user service interface
 * @Author：[bo.wang]
 * @Date: 2021/2/4
 * @Version: 1.0
 */
public interface UserService {

    /**
     * query user info with the specified user id
     *
     * @param userId the user id
     * @return the user info entity
     */
    UserEntity queryForDd1(String userId);

    /**
     * query user info with the specified user id
     *
     * @param userId the user id
     * @return the user info entity
     */
    UserEntity queryForDd2(String userId);
}
