package com.wb.log.service.impl;

import com.wb.log.service.SysOperateLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SysOperateLogServiceImpl
 * @Package: com.wb.log.service.impl
 * @Description: the sys operate log service impl
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysOperateLogServiceImpl implements SysOperateLogService {
}
