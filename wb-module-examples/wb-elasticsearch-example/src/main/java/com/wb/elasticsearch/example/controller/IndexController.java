package com.wb.elasticsearch.example.controller;

import com.wb.common.result.R;
import com.wb.elasticsearch.example.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IndexController
 * @Package: com.wb.elasticsearch.example.controller
 * @Description: the index controller
 * @Author：[bo.wang]
 * @Date: 2021/3/9
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "index/")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping(value = "create")
    public R createIndex(@RequestParam(value = "indexName") String indexName) {
        return indexService.create(indexName);
    }
}
