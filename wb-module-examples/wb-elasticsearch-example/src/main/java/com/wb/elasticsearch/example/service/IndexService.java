package com.wb.elasticsearch.example.service;

import com.wb.common.result.R;

/**
 * @ClassName: IndexService
 * @Package: com.wb.elasticsearch.example.service
 * @Description: the index service
 * @Author：[bo.wang]
 * @Date: 2021/3/9
 * @Version: 1.0
 */
public interface IndexService {

    /**
     * create index with the specified with the index name
     *
     * @param indexName the index name
     * @return
     */
    R create(String indexName);
}
