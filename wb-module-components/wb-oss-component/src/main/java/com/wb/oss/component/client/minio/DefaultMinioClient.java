package com.wb.oss.component.client.minio;

import com.wb.oss.component.request.OssRequest;
import com.wb.oss.component.response.OssResponse;

/**
 * @ClassName: DefaultMinioClient
 * @Package: com.wb.oss.component.client.minio
 * @Description: the default minio client
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class DefaultMinioClient implements MinioClient {

    @Override
    public <T extends OssResponse> T putObject(OssRequest<T> request) {
        return null;
    }
}
