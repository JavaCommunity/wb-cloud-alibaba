package com.wb.oss.component.factorybean;

import com.wb.oss.component.client.OssClient;
import com.wb.oss.component.client.fastdfs.DefaultFastDFSClient;
import com.wb.oss.component.client.fastdfs.FastDFSClient;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName: FastDFSClientFactoryBean
 * @Package: com.wb.oss.component.factorybean
 * @Description: the fastDFS client factory bean
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class FastDFSClientFactoryBean implements FactoryBean<OssClient> {

    @Override
    public OssClient getObject() throws Exception {
        return new DefaultFastDFSClient();
    }

    @Override
    public Class<?> getObjectType() {
        return OssClient.class;
    }
}
