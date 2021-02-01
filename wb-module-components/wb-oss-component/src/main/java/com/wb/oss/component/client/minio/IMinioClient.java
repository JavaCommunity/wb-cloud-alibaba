package com.wb.oss.component.client.minio;

import com.wb.oss.component.client.OssClient;
import com.wb.oss.component.exception.OssServiceException;

/**
 * @ClassName: IMinioClient
 * @Package: com.wb.oss.component.client.minio
 * @Description: the minio client
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public interface IMinioClient extends OssClient {

    /**
     * check bucket is exists with the specified bucket name
     *
     * @param bucketName the bucket name
     * @return <tt>true<tt/> if the minio server exists for the specified bucket name
     */
    boolean bucketExists(String bucketName) throws OssServiceException;

    /**
     * the make bucket with the specified bucket name
     *
     * @param bucketName the bucket name
     * @throws OssServiceException
     */
    void makeBucket(String bucketName) throws OssServiceException;

    /**
     * the make bucket with the specified bucket name and region
     *
     * @param bucketName the bucket name
     * @param region     the region
     * @throws OssServiceException
     */
    void makeBucket(String bucketName, String region) throws OssServiceException;
}
