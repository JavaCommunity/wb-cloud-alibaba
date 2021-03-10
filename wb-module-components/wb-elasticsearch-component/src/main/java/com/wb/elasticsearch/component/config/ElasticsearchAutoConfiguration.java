package com.wb.elasticsearch.component.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.io.Closeable;

/**
 * @ClassName: ElasticsearchAutoConfiguration
 * @Package: com.wb.elasticsearch.component.config
 * @Description: the elasticsearch auto configuration
 * @Author：[bo.wang]
 * @Date: 2021/3/9
 * @Version: 1.0
 */
@Configuration
@ConditionalOnProperty(
        name = "wb-cloud.elasticsearch.enabled",
        havingValue = "true",
        matchIfMissing = true
)
@EnableConfigurationProperties({ElasticsearchProperties.class})
public class ElasticsearchAutoConfiguration implements InitializingBean {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(ElasticsearchAutoConfiguration.class);

    @Autowired
    private ElasticsearchProperties elasticProperties;

    @ConditionalOnMissingBean
    @Bean(name = "restHighLevelClient")
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(elasticProperties.getBuilder());
    }

    @DependsOn({"restHighLevelClient"})
    @Bean(name = "elasticsearchCloseable", destroyMethod = "close")
    public Closeable elasticsearchCloseable(RestHighLevelClient restClient) {
        return new ElasticsearchCloseable(restClient);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[Elasticsearch Starter] Init Elasticsearch.");
    }
}
