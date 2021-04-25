package com.wb.oauth.service.mapper;

import com.wb.oauth.service.entity.OauthUserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserMapper
 * @Package: com.wb.oauth.service.mapper
 * @Description: the user mapper
 * @Author：[bo.wang]
 * @Date: 2021/4/25
 * @Version: 1.0
 */
public interface UserMapper {

    /**
     * 根据登录账号查询用户信息
     *
     * @param account 账号信息
     * @return 用户信息
     */
    OauthUserEntity queryForAccount(@Param(value = "account") String account);
}
