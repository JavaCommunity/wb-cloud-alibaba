package com.wb.log.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SysLoginLogController
 * @Package: com.wb.log.controller
 * @Description: the system login log controller
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "sys/login/log/")
@Api(value = "系统登录日志接口", tags = "系统登录日志接口API")
public class SysLoginLogController {
}
