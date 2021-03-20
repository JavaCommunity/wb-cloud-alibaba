package com.wb.admin.service.modules.route.service.impl;

import com.wb.admin.service.modules.route.service.SysRouteDefinitionService;
import com.wb.admin.service.modules.route.vo.SysRouteDefinitionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SysRouteDefinitionServiceImpl
 * @Package: com.wb.admin.service.modules.route.service.impl
 * @Description: the sys route definition service impl
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRouteDefinitionServiceImpl implements SysRouteDefinitionService {

    @Override
    public void save(SysRouteDefinitionVo definitionVo) {

    }
}
