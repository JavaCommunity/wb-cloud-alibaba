package com.wb.admin.service.modules.user.service;

import com.wb.admin.entity.user.SysUserEntity;
import com.wb.admin.service.modules.user.vo.SysUserSaveVo;

/**
 * @ClassName: SysUserService
 * @Package: com.wb.admin.service.modules.user.service
 * @Description: 系统用户service
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
public interface SysUserService {

    /**
     * 保存用户信息
     *
     * @param userVo
     * @return
     */
    SysUserEntity save(SysUserSaveVo userVo);
}
