package com.wb.sms.component.utils;

import com.wb.sms.component.exception.SmsIllegalArgumentException;

/**
 * @ClassName: SmsRequestCheckUtils
 * @Package: com.wb.sms.component.utils
 * @Description: the sms request check utils
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class SmsRequestCheckUtils {

    //  the error message
    private static final String ERR_MSG = "Missing required arguments：";

    /**
     * check empty with the specified value and field name.
     *
     * @param value     the value
     * @param fieldName the field name
     */
    public static void checkEmpty(Object value, String fieldName) {
        if (value == null) {
            throw new SmsIllegalArgumentException(ERR_MSG + fieldName);
        } else if (value instanceof String && ((String) value).trim().length() == 0) {
            throw new SmsIllegalArgumentException(ERR_MSG + fieldName);
        }
    }
}
