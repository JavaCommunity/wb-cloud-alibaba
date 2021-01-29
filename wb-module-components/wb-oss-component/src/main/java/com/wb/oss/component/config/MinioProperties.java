package com.wb.oss.component.config;

import com.wb.oss.component.factorybean.MinioClientFactoryBean;

/**
 * @ClassName: MinioProperties
 * @Package: com.wb.oss.component.config
 * @Description: the minio properties
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class MinioProperties extends AbstractOssProperties {

    //  the minio object prefix
    private String objectPrefix;

    //  the minio endpoint
    private String endpoint;

    //  the minio access key
    private String accessKey;

    //  the access secret
    private String accessSecret;

    //  the minio region
    private String region;

    /**
     * contract a new minioProperties
     */
    public MinioProperties() {
        super(MinioClientFactoryBean.class);
    }

    public String getObjectPrefix() {
        return objectPrefix;
    }

    public void setObjectPrefix(String objectPrefix) {
        this.objectPrefix = objectPrefix;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
