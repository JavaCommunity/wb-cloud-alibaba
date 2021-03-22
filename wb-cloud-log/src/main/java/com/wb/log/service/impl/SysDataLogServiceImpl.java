package com.wb.log.service.impl;

import com.wb.log.service.SysDataLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SysDataLogServiceImpl
 * @Package: com.wb.log.service.impl
 * @Description: the sys data log service impl
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysDataLogServiceImpl implements SysDataLogService {
}
