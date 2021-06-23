package com.wb.admin.service.modules.user;

import com.wb.admin.entity.user.SysUserEntity;
import com.wb.admin.service.modules.user.service.SysUserService;
import com.wb.admin.service.modules.user.vo.SysUserSaveVo;
import com.wb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SysUserController
 * @Package: com.wb.service.admin.modules.user
 * @Description: the sys user controller
 * @Author：[bo.wang]
 * @Date: 2021/3/5
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "user/")
@Api(value = "平台用户接口", tags = "平台用户接口API")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @PostMapping(value = "v1/save")
    @ApiOperation(value = "新增系统用户信息", httpMethod = "POST")
    public R v1Save(@RequestBody SysUserSaveVo userVo) {
        SysUserEntity userEntity = userService.save(userVo);
        return R.ok().put("id", userEntity.getId());
    }
}
