package com.wb.oss.component.request.minio;

import com.wb.oss.component.request.GenericRequest;
import com.wb.oss.component.response.minio.MinioPutObjectResponse;
import org.springframework.util.Assert;

import java.io.InputStream;

/**
 * @ClassName: MinioPutObjectRequest
 * @Package: com.wb.oss.component.request.minio
 * @Description: the minio put object request
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class MinioPutObjectRequest extends GenericRequest<MinioPutObjectResponse> {

    //  the bucket name
    private String bucketName;

    /**
     * constructs a  new minioPutObjectRequest with the specified bucket name and object
     * name and file input stream
     *
     * @param bucketName the bucket name
     * @param objectName the object name
     * @param input      the file input stream
     */
    public MinioPutObjectRequest(String bucketName, String objectName, InputStream input) {
        super(objectName, input);
        this.bucketName = bucketName;
    }

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
