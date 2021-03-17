package com.wb.sms.component.factorybean;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.wb.sms.component.config.SmsConstants;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName: TencentSmsFactoryBean
 * @Package: com.wb.sms.component.factorybean
 * @Description: the tencent sms factory bean
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class TencentSmsFactoryBean implements FactoryBean<SmsClient> {

    //  the secret id
    private String secretId;

    //  the secret key
    private String secretKey;

    @Override
    public SmsClient getObject() throws Exception {
        Credential cred = new Credential(secretId, secretKey);
        SmsClient client = new SmsClient(cred, SmsConstants.TENCENT_REGION_ID);
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return SmsClient.class;
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
}
