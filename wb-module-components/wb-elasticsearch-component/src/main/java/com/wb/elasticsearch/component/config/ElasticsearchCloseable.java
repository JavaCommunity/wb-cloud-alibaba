package com.wb.elasticsearch.component.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName: ElasticsearchCloseable
 * @Package: com.wb.elasticsearch.component.config
 * @Description: the elasticsearch closeable
 * @Author：[bo.wang]
 * @Date: 2021/3/10
 * @Version: 1.0
 */
public class ElasticsearchCloseable implements Closeable {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(ElasticsearchCloseable.class);

    //  the elasticsearch rest high level client
    private RestHighLevelClient restClient;

    /**
     * constructs a new elasticsearch closeable with the specified rest client
     *
     * @param restClient the rest client
     */
    public ElasticsearchCloseable(RestHighLevelClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public void close() throws IOException {
        log.info("[Elasticsearch Starter] Close Elasticsearch.");
        restClient.close();
    }
}
