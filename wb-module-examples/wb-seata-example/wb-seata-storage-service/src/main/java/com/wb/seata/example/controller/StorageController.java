package com.wb.seata.example.controller;

import com.wb.seata.example.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: StorageController
 * @Package: com.wb.seata.example.controller
 * @Description: the storage controller
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "storage/")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "deduct", method = RequestMethod.GET)
    public Map<String, Object> deduct(@RequestParam(value = "commodityCode") String commodityCode,
                                      @RequestParam(value = "count") Integer count) {
        storageService.deduct(commodityCode, count);
        return new HashMap<String, Object>(2) {{
            put("code", "9999");
            put("message", "操作成功！");
        }};
    }
}
