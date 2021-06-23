package com.wb.admin.service.modules.sub.service.impl;

import com.wb.admin.entity.sub.SysSubEntity;
import com.wb.admin.repository.sub.SysSubRepository;
import com.wb.admin.service.config.AdminContextHolder;
import com.wb.admin.service.exception.AdminServiceException;
import com.wb.admin.service.modules.sub.service.SysSubService;
import com.wb.admin.service.modules.sub.vo.SysSubSaveVo;
import com.wb.common.utils.entity.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SysSubServiceImpl
 * @Package: com.wb.admin.service.modules.sub.service.impl
 * @Description: 平台子系统service impl
 * @Author：[bo.wang]
 * @Date: 2021/4/28
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysSubServiceImpl implements SysSubService {

    @Autowired
    private SysSubRepository subRepository;

    @Override
    public SysSubEntity save(SysSubSaveVo subVo) {
        SysSubEntity subEntity = new SysSubEntity();
        BeanUtils.copyProperties(subVo, subEntity);
        EntityUtils.save(subEntity, AdminContextHolder.getCurrentUser());
        int insertNum = subRepository.insert(subEntity);
        if (insertNum <= 0) {
            throw new AdminServiceException("保存子系统信息失败！");
        }
        return subEntity;
    }
}
