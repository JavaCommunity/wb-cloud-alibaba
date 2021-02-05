package com.wb.feign.provider.example.controller;

import com.wb.common.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Package: com.wb.feign.provider.example.controller
 * @Description: the user controller
 * @Author：[bo.wang]
 * @Date: 2021/2/5
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "user/")
public class UserController {

    @GetMapping(value = "findByUserId")
    private R<Map<String, Object>> findByUserId(@RequestParam(value = "userId") String userId) {
        return R.ok().data(new HashMap<String, Object>(2) {{
            put("userId", userId);
            put("name", "李四");
        }});
    }
}
