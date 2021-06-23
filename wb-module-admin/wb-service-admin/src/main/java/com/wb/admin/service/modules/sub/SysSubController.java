package com.wb.admin.service.modules.sub;

import com.wb.admin.entity.sub.SysSubEntity;
import com.wb.admin.service.modules.sub.service.SysSubService;
import com.wb.admin.service.modules.sub.vo.SysSubSaveVo;
import com.wb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SysSubController
 * @Package: com.wb.admin.service.modules.sub
 * @Description: 平台子系统信息
 * @Author：[bo.wang]
 * @Date: 2021/4/28
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "sub/")
@Api(value = "平台子系统接口", tags = "平台子系统接口API")
public class SysSubController {

    @Autowired
    private SysSubService subService;

    @PostMapping(value = "v1/save")
    @ApiOperation(value = "新增平台子系统信息", httpMethod = "POST")
    public R v1Save(@RequestBody SysSubSaveVo subVo) {
        SysSubEntity subEntity = subService.save(subVo);
        return R.ok().put("id", subEntity.getId());
    }
}
