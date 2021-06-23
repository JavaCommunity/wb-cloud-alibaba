package com.wb.admin.service.modules.user.service;

import com.wb.admin.entity.org.SysOrgEntity;
import com.wb.admin.service.modules.user.vo.SysUserOrgQueryVo;

import java.util.List;

/**
 * @ClassName: SysUserOrgService
 * @Package: com.wb.admin.service.modules.user.service
 * @Description: 平台用户与机构关联信息service
 * @Author：[bo.wang]
 * @Date: 2021/4/28
 * @Version: 1.0
 */
public interface SysUserOrgService {

    /**
     * 根据用户ID查询组织机构信息
     *
     * @param userOrgVo
     * @return
     */
    List<SysOrgEntity> queryForUserId(SysUserOrgQueryVo userOrgVo);
}
