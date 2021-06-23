package com.wb.admin.service.modules.org.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wb.admin.entity.org.SysOrgEntity;
import com.wb.admin.repository.org.SysOrgRepository;
import com.wb.admin.service.modules.org.service.SysOrgService;
import com.wb.admin.service.modules.org.vo.SysOrgQueryVo;
import com.wb.admin.service.modules.user.SysUserOrgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: SysOrgServiceImpl
 * @Package: com.wb.admin.service.modules.org.service
 * @Description: 平台机构service impl
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysOrgServiceImpl implements SysOrgService {

    @Autowired
    private SysOrgRepository orgRepository;
}
