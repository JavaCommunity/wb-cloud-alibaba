package com.wb.oss.component.client;

import com.wb.oss.component.request.OssRequest;
import com.wb.oss.component.response.OssResponse;

/**
 * @ClassName: OssClient
 * @Package: com.wb.oss.component.client
 * @Description: the oss client
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public interface OssClient {

    /**
     * the check object size
     *
     * @param ossRequest the oss request
     */
    default void checkObjectSize(OssRequest ossRequest) {
    }

    /**
     * the put object with the specified request
     *
     * @param request the request
     * @param <T>
     * @return the oss response
     */
    <T extends OssResponse> T putObject(OssRequest<T> request);
}
