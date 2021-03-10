package com.wb.elasticsearch.example;

import com.wb.elasticsearch.component.annotation.EnableElasticsearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: ElasticsearchExampleApplication
 * @Package: com.wb.elasticsearch.example
 * @Description: the elasticsearch example application entry
 * @Author：[bo.wang]
 * @Date: 2021/3/9
 * @Version: 1.0
 */
@EnableElasticsearch
@SpringBootApplication
public class ElasticsearchExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchExampleApplication.class);
    }
}
