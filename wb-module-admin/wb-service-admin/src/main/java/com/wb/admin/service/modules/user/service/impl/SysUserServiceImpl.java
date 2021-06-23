package com.wb.admin.service.modules.user.service.impl;

import com.wb.admin.entity.user.SysUserEntity;
import com.wb.admin.repository.user.SysUserRepository;
import com.wb.admin.service.config.AdminContextHolder;
import com.wb.admin.service.exception.AdminServiceException;
import com.wb.admin.service.modules.user.service.SysUserService;
import com.wb.admin.service.modules.user.vo.SysUserSaveVo;
import com.wb.common.utils.entity.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SysUserServiceImpl
 * @Package: com.wb.admin.service.modules.user.service.impl
 * @Description: 系统用户service impl
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public SysUserEntity save(SysUserSaveVo userVo) {
        SysUserEntity userEntity = new SysUserEntity();
        BeanUtils.copyProperties(userVo, userEntity);
        EntityUtils.save(userEntity, AdminContextHolder.getCurrentUser());
        int insertNum = userRepository.insert(userEntity);
        if (insertNum <= 0) {
            throw new AdminServiceException("保存用户信息失败！");
        }
        return userEntity;
    }
}
