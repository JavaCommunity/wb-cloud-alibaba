package com.wb.sms.component.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SmsProperties
 * @Package: com.wb.sms.component.config
 * @Description: the sms properties
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wb-cloud.sms")
public class SmsProperties {

    //  the aliyun sms properties
    private AliyunSmsProperties aliyun;

    //  the tencent sms properties
    private TencentSmsProperties tencent;

    /**
     * constructs a new smsProperties
     */
//    public SmsProperties() {
//        this.aliyun = new AliyunSmsProperties();
//    }

    /**
     * get all field
     *
     * @return the field
     */
    public Field[] getAllField() {
        List<Field> fields = new ArrayList(32);
        ReflectionUtils.doWithFields(this.getClass(), fields::add);
        return fields.toArray(new Field[0]);
    }

    public AliyunSmsProperties getAliyun() {
        return aliyun;
    }

    public void setAliyun(AliyunSmsProperties aliyun) {
        this.aliyun = aliyun;
    }

    public TencentSmsProperties getTencent() {
        return tencent;
    }

    public void setTencent(TencentSmsProperties tencent) {
        this.tencent = tencent;
    }
}
