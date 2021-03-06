package com.wb.oss.component.client.fastdfs;

import com.wb.oss.component.request.OssRequest;
import com.wb.oss.component.response.GenericResponse;

/**
 * @ClassName: DefaultFastDFSClient
 * @Package: com.wb.oss.component.client.fastdfs
 * @Description: the default fastDFS client
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class DefaultFastDFSClient implements FastDFSClient {

    @Override
    public <T extends GenericResponse> T putObject(OssRequest<T> request) {
        return null;
    }

    @Override
    public <T extends GenericResponse> T getObject(OssRequest<T> request) {
        return null;
    }

    @Override
    public <T extends GenericResponse> T removeObject(OssRequest<T> request) {
        return null;
    }
}
