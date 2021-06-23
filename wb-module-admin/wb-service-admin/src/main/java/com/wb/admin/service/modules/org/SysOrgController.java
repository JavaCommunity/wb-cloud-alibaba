package com.wb.admin.service.modules.org;

import com.wb.admin.service.modules.org.service.SysOrgService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SysOrgController
 * @Package: com.wb.admin.service.modules.org
 * @Description: 平台机构信息
 * @Author：[bo.wang]
 * @Date: 2021/4/27
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "org/")
@Api(value = "平台机构接口", tags = "平台机构接口接口API")
public class SysOrgController {

    @Autowired
    private SysOrgService orgService;
}
