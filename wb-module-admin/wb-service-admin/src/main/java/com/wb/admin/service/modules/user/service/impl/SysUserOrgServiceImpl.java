package com.wb.admin.service.modules.user.service.impl;

import com.wb.admin.entity.org.SysOrgEntity;
import com.wb.admin.repository.user.SysUserOrgRepository;
import com.wb.admin.service.modules.user.service.SysUserOrgService;
import com.wb.admin.service.modules.user.vo.SysUserOrgQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: SysUserOrgServiceImpl
 * @Package: com.wb.admin.service.modules.user.service.impl
 * @Description: 平台用户与机构关联关系信息service impl
 * @Author：[bo.wang]
 * @Date: 2021/4/28
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserOrgServiceImpl implements SysUserOrgService {

    @Autowired
    private SysUserOrgRepository userOrgRepository;

    @Override
    public List<SysOrgEntity> queryForUserId(SysUserOrgQueryVo userOrgVo) {
        // return userOrgRepository.queryForUserId(userOrgVo);
        return null;
    }
}
