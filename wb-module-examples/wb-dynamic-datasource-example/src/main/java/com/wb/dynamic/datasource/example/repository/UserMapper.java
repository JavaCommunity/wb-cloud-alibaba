package com.wb.dynamic.datasource.example.repository;

import com.wb.dynamic.datasource.example.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: UserMapper
 * @Package: com.wb.dynamic.datasource.example.repository
 * @Description: the user mapper
 * @Author：[bo.wang]
 * @Date: 2021/2/4
 * @Version: 1.0
 */
public interface UserMapper {

    /**
     * query user info with the specified user id
     *
     * @param userId the user id
     * @return the user info entity
     */
    @Select("select * from user where id = #{userId}")
    UserEntity queryForDd1(@Param(value = "userId") String userId);

    /**
     * query user info with the specified user id
     *
     * @param userId the user id
     * @return the user info entity
     */
    @Select("select * from user where id = #{userId}")
    UserEntity queryForDd2(@Param(value = "userId") String userId);
}
