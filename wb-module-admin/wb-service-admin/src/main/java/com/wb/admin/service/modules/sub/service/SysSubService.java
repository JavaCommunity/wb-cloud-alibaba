package com.wb.admin.service.modules.sub.service;

import com.wb.admin.entity.sub.SysSubEntity;
import com.wb.admin.service.modules.sub.vo.SysSubSaveVo;

/**
 * @ClassName: SysSubService
 * @Package: com.wb.admin.service.modules.sub.service
 * @Description: 平台子系统service
 * @Author：[bo.wang]
 * @Date: 2021/4/28
 * @Version: 1.0
 */
public interface SysSubService {

    /**
     * 新增信息
     *
     * @param subVo
     * @return
     */
    SysSubEntity save(SysSubSaveVo subVo);
}
