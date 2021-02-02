package com.wb.oss.component.client;

import com.wb.oss.component.request.OssRequest;
import com.wb.oss.component.response.GenericResponse;

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
     * the put object with the specified request
     *
     * @param request the request
     * @param <T>
     * @return the oss response
     */
    <T extends GenericResponse> T putObject(OssRequest<T> request);

    /**
     * the get object with the specified request
     *
     * @param request the request
     * @param <T>
     * @return the oss response
     */
    <T extends GenericResponse> T getObject(OssRequest<T> request);

    /**
     * the remove object with the specified request
     *
     * @param request the request
     * @param <T>
     * @return the oss response
     */
    <T extends GenericResponse> T removeObject(OssRequest<T> request);
}
