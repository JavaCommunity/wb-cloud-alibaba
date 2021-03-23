package com.wb.sign.component.utils;

import com.timevale.esign.sdk.tech.bean.result.Result;
import com.wb.sign.component.command.result.SignResult;
import com.wb.sign.component.config.SignErrorEnum;
import com.wb.sign.component.exception.SignEBaoException;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName: EBaoUtils
 * @Package: com.wb.sign.component.utils
 * @Description: the e bao utils
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class EBaoUtils {

    //  the default err code
    private static final int DEFAULT_ERR_CODE = 0;

    /**
     * check is ok with the e bao result
     *
     * @param result the e bao result
     */
    public static void isOk(Result result) {
        if (ObjectUtils.isEmpty(result)) {
            throw new SignEBaoException(SignErrorEnum.E_BAO_SYSTEM.getMsg());
        }
        int errCode = result.getErrCode();
        if (DEFAULT_ERR_CODE != errCode) {
            throw new SignEBaoException(result.getMsg());
        }
    }

    /**
     * e bao result handler with the specified result and cls.
     *
     * @param result the e bao result
     * @param cls    the cls
     * @param <T>
     * @return the result obj
     */
    public static <T extends SignResult> T result(Result result, Class<T> cls) {
        SignResult t = BeanUtils.instantiateClass(cls);
        if (ObjectUtils.isEmpty(result)) {
            t.setErrCode(SignErrorEnum.E_BAO_SYSTEM.getCode());
            t.setErrMsg(SignErrorEnum.E_BAO_SYSTEM.getMsg());
            return (T) t;
        }
        if (DEFAULT_ERR_CODE != result.getErrCode()) {
            t.setErrCode(SignErrorEnum.E_BAO_SYSTEM.getCode());
            t.setErrMsg(result.getMsg());
            return (T) t;
        }
        BeanUtils.copyProperties(result, t);
        t.setErrCode(SignErrorEnum.SUCCESS.getCode());
        t.setErrMsg(SignErrorEnum.SUCCESS.getMsg());
        return (T) t;
    }
}
