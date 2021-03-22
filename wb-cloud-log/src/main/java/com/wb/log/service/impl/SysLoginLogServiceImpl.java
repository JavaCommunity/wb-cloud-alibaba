package com.wb.log.service.impl;

import com.wb.log.service.SysLoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SysLoginLogServiceImpl
 * @Package: com.wb.log.service.impl
 * @Description: the system login log service impl
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysLoginLogServiceImpl implements SysLoginLogService {
}
