package com.wb.oss.component.request.minio;

import com.wb.oss.component.request.BaseOssRequest;
import com.wb.oss.component.response.minio.MinioPutResponse;
import org.springframework.util.Assert;

/**
 * @ClassName: MinioPutRequest
 * @Package: com.wb.oss.component.request.minio
 * @Description: the minio put request
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class MinioPutRequest extends BaseOssRequest<MinioPutResponse> {

    //  the bucket name
    private String bucketName;

    @Override
    public void check() throws IllegalAccessException {
        Assert.hasLength(this.getBucketName(), "'bucketName' must not be null！");
        Assert.hasLength(this.getObjectName(), "'objectName' must not be null！");
        Assert.notNull(this.getObjectContent(), "'objectContent' must not be null！");
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
