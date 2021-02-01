package com.wb.oss.component.config;

import com.wb.oss.component.factorybean.FastDFSClientFactoryBean;

/**
 * @ClassName: FastDFSProperties
 * @Package: com.wb.oss.component.config
 * @Description: the fastDFS properties
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public class FastDFSProperties extends AbstractOssProperties {

    /**
     * constructs a new fastDFSProperties
     */
    public FastDFSProperties() {
        super(FastDFSClientFactoryBean.class);
    }
}
