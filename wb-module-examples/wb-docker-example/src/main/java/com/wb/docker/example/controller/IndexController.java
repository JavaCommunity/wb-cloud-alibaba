package com.wb.docker.example.controller;

import com.wb.common.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IndexController
 * @Package: com.wb.docker.example.controller
 * @Description: the index controller
 * @Author：[bo.wang]
 * @Date: 2021/1/27
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "index/")
public class IndexController {

    @GetMapping(value = "/test")
    public R test() {
        return R.ok();
    }
}
