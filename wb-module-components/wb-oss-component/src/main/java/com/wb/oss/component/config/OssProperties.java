package com.wb.oss.component.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;

/**
 * @ClassName: OssProperties
 * @Package: com.wb.oss.component.config
 * @Description: the oss properties
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wb-cloud.oss")
public class OssProperties {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(OssProperties.class);

    //  the server type
    private String type;

    //  the minio properties
    private MinioProperties minio;

    //  the fastDFS properties
    private FastDFSProperties fastdfs;

    /**
     * contract a new ossProperties
     */
    public OssProperties() {
        this.type = OssConstants.DEFAULT_OSS_SERVER_TYPE;
        this.minio = new MinioProperties();
        this.fastdfs = new FastDFSProperties();
    }

    /**
     * get abstract oss properties with the specified type
     *
     * @param type the type
     * @return the abstract oss properties
     */
    public AbstractOssProperties getOssProperties(String type) {
        Assert.hasLength(type, "'type' must not be null！");

        try {
            Field declaredField = this.getClass().getDeclaredField(type);
            declaredField.setAccessible(true);
            AbstractOssProperties abstractOssProperties = (AbstractOssProperties) declaredField.get(this);
            if (ObjectUtils.isEmpty(abstractOssProperties)) {
                log.error("[OSS Starter] properties won't loaded：" + type);
                return null;
            }
            return abstractOssProperties;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MinioProperties getMinio() {
        return minio;
    }

    public void setMinio(MinioProperties minio) {
        this.minio = minio;
    }

    public FastDFSProperties getFastdfs() {
        return fastdfs;
    }

    public void setFastdfs(FastDFSProperties fastdfs) {
        this.fastdfs = fastdfs;
    }
}
