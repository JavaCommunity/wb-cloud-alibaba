package com.wb.oss.component.factorybean;

import com.wb.oss.component.client.OssClient;
import com.wb.oss.component.client.minio.DefaultMinioClient;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName: MinioClientFactoryBean
 * @Package: com.wb.oss.component.factorybean
 * @Description: the minio client factory bean
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class MinioClientFactoryBean implements FactoryBean<OssClient> {

    @Override
    public OssClient getObject() throws Exception {
        return new DefaultMinioClient();
    }

    @Override
    public Class<?> getObjectType() {
        return OssClient.class;
    }
}
