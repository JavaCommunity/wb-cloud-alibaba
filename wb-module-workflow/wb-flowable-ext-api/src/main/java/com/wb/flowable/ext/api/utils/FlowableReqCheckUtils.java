package com.wb.flowable.ext.api.utils;

import org.flowable.common.engine.api.FlowableIllegalArgumentException;

/**
 * @ClassName: FlowableUtils
 * @Package: com.wb.flowable.ext.api.utils
 * @Description: the flowable request check utils
 * @Author：[bo.wang]
 * @Date: 2021/2/25
 * @Version: 1.0
 */
public class FlowableReqCheckUtils {

    //  the error message
    private static final String ERR_MSG = "flowable-error:Missing required arguments:";

    /**
     * check empty with the specified value and field name.
     *
     * @param value     the value
     * @param fieldName the field name
     */
    public static void checkEmpty(Object value, String fieldName) {
        if (value == null) {
            throw new FlowableIllegalArgumentException(ERR_MSG + fieldName);
        } else if (value instanceof String && ((String) value).trim().length() == 0) {
            throw new FlowableIllegalArgumentException(ERR_MSG + fieldName);
        }
    }
}
