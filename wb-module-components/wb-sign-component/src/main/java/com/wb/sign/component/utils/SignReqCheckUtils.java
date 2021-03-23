package com.wb.sign.component.utils;

import com.wb.sign.component.exception.SignIllegalArgumentException;

/**
 * @ClassName: SignReqCheckUtils
 * @Package: com.wb.sign.component.utils
 * @Description: the sign request check utils
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class SignReqCheckUtils {

    //  the error message
    private static final String ERR_MSG = ":Missing required arguments:";

    /**
     * check empty with the specified value and field name.
     *
     * @param value     the value
     * @param fieldName the field name
     */
    public static void checkEmpty(Object value, String fieldName) {
        if (value == null) {
            throw new SignIllegalArgumentException(ERR_MSG + fieldName);
        } else if (value instanceof String && ((String) value).trim().length() == 0) {
            throw new SignIllegalArgumentException(ERR_MSG + fieldName);
        }
    }
}
