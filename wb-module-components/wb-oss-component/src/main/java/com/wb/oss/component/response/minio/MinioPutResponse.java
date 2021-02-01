package com.wb.oss.component.response.minio;

import com.wb.oss.component.config.OssErrorCodeEnum;
import com.wb.oss.component.response.OssResponse;

import java.io.Serializable;

/**
 * @ClassName: MinioPutResponse
 * @Package: com.wb.oss.component.response.minio
 * @Description: the minio put response
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class MinioPutResponse extends OssResponse implements Serializable {

    //  the object id
    private String objectId;

    //  the content type
    private String contentType;

    //  the object size
    private long size;

    //  the bucket name
    private String bucketName;

    /**
     * create a new minioResponse
     *
     * @return the minioResponse
     */
    public static MinioPutResponse ok() {
        return new MinioPutResponse(OssErrorCodeEnum.SUCCESS.getErrCode(),
                OssErrorCodeEnum.SUCCESS.getErrMsg());
    }

    /**
     * create a new minioResponse
     *
     * @return the minioResponse
     */
    public static MinioPutResponse error() {
        return new MinioPutResponse(OssErrorCodeEnum.FAIL.getErrCode(),
                OssErrorCodeEnum.FAIL.getErrMsg());
    }

    /**
     * create a new minioResponse
     *
     * @return the minioResponse
     */
    public static MinioPutResponse error(String errMsg) {
        return new MinioPutResponse(OssErrorCodeEnum.FAIL.getErrCode(), errMsg);
    }

    /**
     * contract a new minioResponse with the error code and error message
     *
     * @param errCode the error code
     * @param errMsg  the error message
     */
    public MinioPutResponse(String errCode, String errMsg) {
        this.setErrCode(errCode);
        this.setErrMsg(errMsg);
    }

    /**
     * set object id
     *
     * @param objectId the object id
     * @return this minio response
     */
    public MinioPutResponse objectId(String objectId) {
        this.objectId = objectId;
        return this;
    }

    /**
     * set bucket name
     *
     * @param bucketName the bucket name
     * @return this minio response
     */
    public MinioPutResponse bucketName(String bucketName) {
        this.bucketName = bucketName;
        return this;
    }

    /**
     * set content type
     *
     * @param contentType the content type
     * @return this minio response
     */
    public MinioPutResponse contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * set size
     *
     * @param size the size
     * @return the minio response
     */
    public MinioPutResponse size(long size) {
        this.size = size;
        return this;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
