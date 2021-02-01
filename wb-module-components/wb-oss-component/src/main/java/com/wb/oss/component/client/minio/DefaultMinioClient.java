package com.wb.oss.component.client.minio;

import com.wb.oss.component.config.OssErrorCodeEnum;
import com.wb.oss.component.exception.OssServiceException;
import com.wb.oss.component.request.OssRequest;
import com.wb.oss.component.request.minio.MinioGetRequest;
import com.wb.oss.component.request.minio.MinioPutRequest;
import com.wb.oss.component.request.minio.MinioRemoveRequest;
import com.wb.oss.component.response.OssResponse;
import com.wb.oss.component.response.minio.MinioGetResponse;
import com.wb.oss.component.response.minio.MinioPutResponse;
import com.wb.oss.component.response.minio.MinioRemoveResponse;
import com.wb.oss.component.utils.RequestCheckUtils;
import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.InputStream;

/**
 * @ClassName: DefaultMinioClient
 * @Package: com.wb.oss.component.client.minio
 * @Description: the default minio client
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class DefaultMinioClient implements IMinioClient {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(DefaultMinioClient.class);

    //  the auto create bucket
    private static final boolean AUTO_CREATE_BUCKET = true;

    //  the minio client
    private final MinioClient minioClient;

    /**
     * constructs a new defaultMinioClient with the specified minioClient
     *
     * @param minioClient the minioClient
     */
    public DefaultMinioClient(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public <T extends OssResponse> T putObject(OssRequest<T> request) {
        try {
            MinioPutRequest req = (MinioPutRequest) request;
            req.check();

            String bucketName = req.getBucketName();
            boolean exists = this.bucketExists(bucketName);
            if (!exists) {
                this.makeBucket(bucketName);
            }

            minioClient.putObject(bucketName, req.getObjectName(), req.getObjectContent(), req.getContentType());
            return (T) MinioPutResponse.ok()
                    .objectId(req.getObjectId())
                    .bucketName(req.getBucketName())
                    .contentType(req.getContentType())
                    .size(req.getSize());
        } catch (OssServiceException e) {
            return (T) MinioPutResponse.error(e.getMessage());
        } catch (Exception e) {
            log.error("[Oss Starter] Minio Put Object Error,ErrMsg:{}", e.getMessage());
            return (T) MinioPutResponse.error(e.getMessage());
        }
    }

    @Override
    public <T extends OssResponse> T getObject(OssRequest<T> request) {
        try {
            MinioGetRequest req = (MinioGetRequest) request;

            String bucketName = req.getBucketName();
            boolean isExists = this.bucketExists(bucketName);
            if (!isExists) {
                return (T) new MinioGetResponse(OssErrorCodeEnum.FAIL.getErrCode(), "Minio Bucket Not Exists！");
            }

            InputStream objectContent = minioClient.getObject(bucketName, req.getObjectName());
            MinioGetResponse response = new MinioGetResponse(OssErrorCodeEnum.SUCCESS.getErrCode(), OssErrorCodeEnum.SUCCESS.getErrMsg());
            response.setObjectContent(objectContent);
            return (T) response;
        } catch (Exception e) {
            log.error("[Oss Starter] Minio Get Object Error,ErrMsg:{}", e.getMessage());
            return (T) new MinioGetResponse(OssErrorCodeEnum.FAIL.getErrCode(), OssErrorCodeEnum.FAIL.getErrMsg());
        }
    }

    @Override
    public <T extends OssResponse> T removeObject(OssRequest<T> request) {
        try {
            MinioRemoveRequest req = (MinioRemoveRequest) request;

            String bucketName = req.getBucketName();
            boolean isExists = this.bucketExists(bucketName);
            if (!isExists) {
                return (T) new MinioRemoveResponse(OssErrorCodeEnum.FAIL.getErrCode(), "Minio Bucket Not Exists！");
            }

            minioClient.removeObject(bucketName, req.getObjectName());
            return (T) new MinioRemoveResponse(OssErrorCodeEnum.SUCCESS.getErrCode(), OssErrorCodeEnum.SUCCESS.getErrMsg());
        } catch (Exception e) {
            log.error("[Oss Starter] Minio Remove Object Error,ErrMsg:{}", e.getMessage());
            return (T) new MinioRemoveResponse(OssErrorCodeEnum.FAIL.getErrCode(), OssErrorCodeEnum.FAIL.getErrMsg());
        }
    }

    @Override
    public boolean bucketExists(String bucketName) throws OssServiceException {
        Assert.hasLength(bucketName, "'bucketName' must not be null！");

        RequestCheckUtils.checkBucket(bucketName);
        try {
            return minioClient.bucketExists(bucketName);
        } catch (Exception e) {
            log.error("[Oss Starter] Check Minio Bucket Is Exists Error,ErrMsg:{}", e.getMessage());
            throw new OssServiceException(e.getMessage(), DefaultMinioClient.class);
        }
    }

    @Override
    public void makeBucket(String bucketName) throws OssServiceException {
        this.makeBucket(bucketName, null);
    }

    @Override
    public void makeBucket(String bucketName, String region) throws OssServiceException {
        Assert.hasLength(bucketName, "'bucketName' must not be null！");

        RequestCheckUtils.checkBucket(bucketName);
        if (!AUTO_CREATE_BUCKET) {
            throw new OssServiceException("Minio Server Not Open Auto Create Bucket！", DefaultMinioClient.class);
        }
        try {
            if (StringUtils.isEmpty(region)) {
                minioClient.makeBucket(bucketName);
            } else {
                minioClient.makeBucket(bucketName, region);
            }
        } catch (Exception e) {
            log.error("[Oss Starter] Make Bucket Error,ErrMsg:{}", e.getMessage());
            throw new OssServiceException(e.getMessage(), DefaultMinioClient.class);
        }
    }
}
