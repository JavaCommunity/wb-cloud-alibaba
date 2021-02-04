package com.wb.quartz.example.controller;

import com.wb.common.result.R;
import com.wb.quartz.component.client.QuartzClient;
import com.wb.quartz.component.vo.QuartzJobVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: QuartzController
 * @Package: com.wb.quartz.example.controller
 * @Description: the quartz controller
 * @Author：[bo.wang]
 * @Date: 2021/2/3
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "quartz/")
public class QuartzController {

    @Autowired
    private QuartzClient quartzClient;

    @PostMapping(value = "create")
    public R create(@RequestBody QuartzJobVo jobVo) {
        quartzClient.create(jobVo);
        return R.ok();
    }
}
