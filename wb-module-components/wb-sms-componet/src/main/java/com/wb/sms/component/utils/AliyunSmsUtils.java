package com.wb.sms.component.utils;

import com.aliyuncs.AcsResponse;

/**
 * @ClassName: AliyunSmsUtils
 * @Package: com.wb.sms.component.utils
 * @Description: the aliyun sms utils
 * @Author：[bo.wang]
 * @Date: 2021/3/16
 * @Version: 1.0
 */
public class AliyunSmsUtils {

    public static void isOk(AcsResponse acsResponse) {
        SmsRequestCheckUtils.checkEmpty(acsResponse, "acsResponse");
    }
}
