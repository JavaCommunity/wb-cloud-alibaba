package com.wb.sms.component.config;

import com.wb.sms.component.factorybean.TencentSmsFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @ClassName: TencentSmsProperties
 * @Package: com.wb.sms.component.config
 * @Description: the tencent sms properties
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class TencentSmsProperties extends AbstractSmsProperties {

    //  the secret id
    private String secretId;

    //  the secret key
    private String secretKey;

    //  the endpoint
    private String endpoint;

    //  the appid
    private String appid;

    //  the sign
    private String sign;

    /**
     * constructs a new abstractSmsProperties
     */
    public TencentSmsProperties() {
        super(TencentSmsFactoryBean.class);
    }

    @Override
    public void check(DefaultListableBeanFactory beanFactory) {
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
