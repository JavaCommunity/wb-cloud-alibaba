package com.wb.elasticsearch.component.exception;

/**
 * @ClassName: ElasticsearchException
 * @Package: com.wb.elasticsearch.component.exception
 * @Description: the elasticsearch exception
 * @Author：[bo.wang]
 * @Date: 2021/3/9
 * @Version: 1.0
 */
public class ElasticsearchException extends RuntimeException {

    public ElasticsearchException(String message) {
        super(message);
    }

    public ElasticsearchException(String message, Throwable cause) {
        super(message, cause);
    }
}
