package com.wb.admin.service.modules.route.service;

import com.wb.admin.service.modules.route.vo.SysRouteDefinitionVo;

/**
 * @ClassName: SysRouteDefinitionService
 * @Package: com.wb.admin.service.modules.route.service
 * @Description: the sys route definition service
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public interface SysRouteDefinitionService {

    /**
     * save route definition info with the specified definition vo
     *
     * @param definitionVo the definition vo
     */
    void save(SysRouteDefinitionVo definitionVo);
}
