package com.wb.oss.component.request.minio;

import com.wb.oss.component.request.OssRequest;
import com.wb.oss.component.response.minio.MinioGetObjectResponse;
import org.springframework.util.Assert;

/**
 * @ClassName: MinioGetObjectRequest
 * @Package: com.wb.oss.component.request.minio
 * @Description: the minio get request
 * @Author：[bo.wang]
 * @Date: 2021/2/1
 * @Version: 1.0
 */
public class MinioGetObjectRequest implements OssRequest<MinioGetObjectResponse> {

    //  the bucket name
    private String bucketName;

    //  the object name
    private String objectName;

    /**
     * constructs a new minioGetObjectRequest with the specified bucket name and object name
     *
     * @param bucketName the bucket name
     * @param objectName the object name
     */
    public MinioGetObjectRequest(String bucketName, String objectName) {
        this.bucketName = bucketName;
        this.objectName = objectName;
    }

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
