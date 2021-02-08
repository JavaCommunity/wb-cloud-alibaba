package com.wb.sentinel.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FlowControlController
 * @Package: com.wb.sentinel.example.controller
 * @Description: the sentinel flow control controller
 * @Author：[bo.wang]
 * @Date: 2021/2/8
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "flow/control/")
public class FlowControlController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "Hello word!";
    }
}
