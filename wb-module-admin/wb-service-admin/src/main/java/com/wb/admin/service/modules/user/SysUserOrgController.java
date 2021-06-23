package com.wb.admin.service.modules.user;

import com.wb.admin.entity.org.SysOrgEntity;
import com.wb.admin.service.modules.user.service.SysUserOrgService;
import com.wb.admin.service.modules.user.vo.SysUserOrgQueryVo;
import com.wb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: SysUserOrgController
 * @Package: com.wb.admin.service.modules.user
 * @Description: 平台用户与机构关联信息
 * @Author：[bo.wang]
 * @Date: 2021/4/25
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "user/org/")
@Api(value = "平台用户机构接口", tags = "平台用户机构接口API")
public class SysUserOrgController {

    @Autowired
    private SysUserOrgService userOrgService;

    @PostMapping(value = "v1/queryForUserId")
    @ApiOperation(value = "根据用户ID查询机构信息", httpMethod = "POST")
    public R<List<SysOrgEntity>> v1QueryForUserId(@RequestBody SysUserOrgQueryVo userOrgVo) {
        List<SysOrgEntity> orgList = userOrgService.queryForUserId(userOrgVo);
        return R.ok().data(orgList);
    }
}
