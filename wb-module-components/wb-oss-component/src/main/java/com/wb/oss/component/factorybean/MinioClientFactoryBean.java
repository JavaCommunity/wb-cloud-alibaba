package com.wb.oss.component.factorybean;

import com.wb.oss.component.client.OssClient;
import com.wb.oss.component.client.minio.DefaultMinioClient;
import com.wb.oss.component.config.MinioProperties;
import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.Assert;

/**
 * @ClassName: MinioClientFactoryBean
 * @Package: com.wb.oss.component.factorybean
 * @Description: the minio client factory bean
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class MinioClientFactoryBean implements FactoryBean<OssClient> {

    //  the slf4j log
    private static final Logger log = LoggerFactory.getLogger(MinioClientFactoryBean.class);

    //  the minio properties
    private MinioProperties ossProperties;

    @Override
    public OssClient getObject() throws Exception {
        Assert.notNull(ossProperties, "'minioProperties' must not be null！");
        try {
            MinioClient minioClient = new MinioClient(ossProperties.getEndpoint(),
                    ossProperties.getAccessKey(), ossProperties.getAccessSecret());
            return new DefaultMinioClient(minioClient);
        } catch (Exception e) {
            log.error("[Oss Starter] Create Minio Client Error,ErrMsg:{}", e.getMessage());
        }
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return OssClient.class;
    }

    public MinioProperties getOssProperties() {
        return ossProperties;
    }

    public void setOssProperties(MinioProperties ossProperties) {
        this.ossProperties = ossProperties;
    }
}
