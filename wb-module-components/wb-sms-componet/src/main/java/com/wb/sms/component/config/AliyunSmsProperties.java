package com.wb.sms.component.config;

import com.wb.sms.component.factorybean.AliyunSmsFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @ClassName: AliyunSmsProperties
 * @Package: com.wb.sms.component.config
 * @Description: the aliyun sms properties
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class AliyunSmsProperties extends AbstractSmsProperties {

    //  the default connect timeout
    private static final String DEFAULT_CONNECT_TIMEOUT = "10000";

    //  the default read timeout
    private static final String DEFAULT_READ_TIMEOUT = "10000";

    //  the connect timeout
    private String connectTimeout = DEFAULT_CONNECT_TIMEOUT;

    //  the read timeout
    private String readTimeout = DEFAULT_READ_TIMEOUT;

    //  the product
    private String product = "Dysmsapi";

    //  the domain
    private String domain = "dysmsapi.aliyuncs.com";

    //  the access key id
    private String accessKeyId;

    //  the access key secret
    private String accessKeySecret;

    /**
     * constructs a new aliyunSmsProperties
     */
    public AliyunSmsProperties() {
        super(AliyunSmsFactoryBean.class);
    }

    @Override
    public void check(DefaultListableBeanFactory beanFactory) {
    }

    public String getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(String readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
