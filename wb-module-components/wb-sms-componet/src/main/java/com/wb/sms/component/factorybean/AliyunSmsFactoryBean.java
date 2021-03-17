package com.wb.sms.component.factorybean;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.wb.sms.component.config.SmsConstants;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName: AliyunSmsFactoryBean
 * @Package: com.wb.sms.component.factorybean
 * @Description: the aliyun sms client factory bean
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class AliyunSmsFactoryBean implements FactoryBean<IAcsClient> {

    //  the connect timeout
    private String connectTimeout;

    //  the read timeout
    private String readTimeout;

    //  the product
    private String product;

    //  the domain
    private String domain;

    //  the access key id
    private String accessKeyId;

    //  the access key secret
    private String accessKeySecret;

    @Override
    public IAcsClient getObject() throws Exception {
        System.setProperty("sun.net.client.defaultConnectTimeout", connectTimeout);
        System.setProperty("sun.net.client.defaultReadTimeout", readTimeout);
        IClientProfile profile = DefaultProfile.getProfile(
                SmsConstants.ALIYUN_REGION_ID,
                accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint(
                SmsConstants.ALIYUN_ENDPOINT_NAME,
                SmsConstants.ALIYUN_REGION_ID,
                product,
                domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        return acsClient;
    }

    @Override
    public Class<?> getObjectType() {
        return IAcsClient.class;
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
