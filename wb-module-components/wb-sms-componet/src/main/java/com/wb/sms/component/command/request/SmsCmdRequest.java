package com.wb.sms.component.command.request;

/**
 * @ClassName: SmsCmdRequest
 * @Package: com.wb.sms.component.command.request
 * @Description: the sms request
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public interface SmsCmdRequest<T> {

    //  the check request
    default void check() {

    }
}
