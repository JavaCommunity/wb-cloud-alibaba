package com.wb.workflow.core.utils;

import com.wb.workflow.core.exception.WorkFlowIllegalArgumentException;

/**
 * @ClassName: WorkFlowReqCheckUtils
 * @Package: com.wb.workflow.core.utils
 * @Description: the work flow request check utils
 * @Author：[bo.wang]
 * @Date: 2021/2/20
 * @Version: 1.0
 */
public class WorkFlowReqCheckUtils {

    //  the error message
    private static final String ERR_MSG = "workFlow-error:Missing required arguments:";

    /**
     * check empty with the specified value and field name.
     *
     * @param value     the value
     * @param fieldName the field name
     */
    public static void checkEmpty(Object value, String fieldName) {
        if (value == null) {
            throw new WorkFlowIllegalArgumentException(ERR_MSG + fieldName);
        } else if (value instanceof String && ((String) value).trim().length() == 0) {
            throw new WorkFlowIllegalArgumentException(ERR_MSG + fieldName);
        }
    }
}
