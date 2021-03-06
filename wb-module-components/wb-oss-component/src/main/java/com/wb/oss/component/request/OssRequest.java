package com.wb.oss.component.request;

import com.wb.oss.component.response.GenericResponse;

/**
 * @ClassName: OssRequest
 * @Package: com.wb.oss.component.request
 * @Description: the oss request
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public interface OssRequest<T extends GenericResponse> {

    /**
     * the oss request check
     *
     * @throws IllegalAccessException
     */
    void check() throws IllegalAccessException;
}
