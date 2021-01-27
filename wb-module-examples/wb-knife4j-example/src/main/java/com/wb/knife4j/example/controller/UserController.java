package com.wb.knife4j.example.controller;

import com.wb.common.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Package: com.wb.knife4j.example.controller
 * @Description: the user controller
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/user/")
@Api(tags = "用户信息接口API", value = "用户信息接口API")
public class UserController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "测试用户接口", notes = "测试用户接口", httpMethod = "GET", code = 9999)
    public R test() {
        return R.ok();
    }
}
