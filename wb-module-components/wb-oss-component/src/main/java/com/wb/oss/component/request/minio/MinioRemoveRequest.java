package com.wb.oss.component.request.minio;

import com.wb.oss.component.request.OssRequest;
import com.wb.oss.component.response.minio.MinioRemoveResponse;
import org.springframework.util.Assert;

/**
 * @ClassName: MinioRemoveRequest
 * @Package: com.wb.oss.component.request.minio
 * @Description: the minio remove request
 * @Author：[bo.wang]
 * @Date: 2021/2/1
 * @Version: 1.0
 */
public class MinioRemoveRequest implements OssRequest<MinioRemoveResponse> {

    //  the bucket name
    private String bucketName;

    //  the object name
    private String objectName;

    @Override
    public void check() throws IllegalAccessException {
        Assert.hasLength(objectName, "'objectName' must not be null！");
        Assert.hasLength(bucketName, "'bucketName' must not be null！");
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
