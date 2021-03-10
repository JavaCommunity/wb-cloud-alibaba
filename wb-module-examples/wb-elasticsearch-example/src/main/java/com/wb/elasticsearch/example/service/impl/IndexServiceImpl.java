package com.wb.elasticsearch.example.service.impl;

import com.wb.common.result.R;
import com.wb.elasticsearch.example.service.IndexService;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * @ClassName: IndexServiceImpl
 * @Package: com.wb.elasticsearch.example.service.impl
 * @Description: the index service impl
 * @Author：[bo.wang]
 * @Date: 2021/3/9
 * @Version: 1.0
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private RestHighLevelClient restClient;

    @Override
    public R create(String indexName) {
        Assert.hasText(indexName, "'indexName' must not be null！");

        CreateIndexRequest request = new CreateIndexRequest(indexName);
        CreateIndexResponse createIndexResponse = null;
        try {
            createIndexResponse = restClient.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!createIndexResponse.isAcknowledged()) {
            return R.error("创建索引失败，请稍后再试！");
        }
        return R.ok();
    }
}
