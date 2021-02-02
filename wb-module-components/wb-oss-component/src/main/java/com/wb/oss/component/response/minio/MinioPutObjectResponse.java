package com.wb.oss.component.response.minio;

import com.wb.oss.component.config.OssErrorCodeEnum;
import com.wb.oss.component.response.GenericResponse;

/**
 * @ClassName: MinioPutObjectResponse
 * @Package: com.wb.oss.component.response.minio
 * @Description: the minio put object response
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class MinioPutObjectResponse extends GenericResponse {

    //  the object id
    private String objectId;

    //  the object name
    private String objectName;

    //  the bucket name
    private String bucketName;

    //  the content type
    private String contentType;

    //  the object size
    private long size;

    /**
     * constructs a new minioPutObjectResponse with the specified error message
     *
     * @param errMsg the error message
     */
    public MinioPutObjectResponse(String errMsg) {
        super(OssErrorCodeEnum.SUCCESS.getErrCode(), errMsg);
    }

    /**
     * constructs a new minioPutObjectResponse with the specified object id
     * and object name and bucket name and content type and size
     *
     * @param objectId    the object id
     * @param objectName  the object name
     * @param bucketName  the bucket name
     * @param contentType the content type
     * @param size        the size
     */
    public MinioPutObjectResponse(String objectId, String objectName, String bucketName, String contentType, long size) {
        super(OssErrorCodeEnum.SUCCESS.getErrCode(), OssErrorCodeEnum.SUCCESS.getErrMsg());
        this.objectId = objectId;
        this.objectName = objectName;
        this.bucketName = bucketName;
        this.contentType = contentType;
        this.size = size;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
