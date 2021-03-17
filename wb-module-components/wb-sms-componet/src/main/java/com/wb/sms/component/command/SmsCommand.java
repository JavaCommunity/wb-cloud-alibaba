package com.wb.sms.component.command;

import com.wb.sms.component.command.request.SmsCmdRequest;

/**
 * @ClassName: SmsCommand
 * @Package: com.wb.sms.component.command
 * @Description: the sms command
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public interface SmsCommand {

    /**
     * the before execute command
     *
     * @param cmdRequest this cmd request
     */
    default void before(SmsCmdRequest cmdRequest) {
    }

    /**
     * the execute command
     *
     * @return
     */
    <T> T execute(SmsCmdRequest<T> cmdRequest);

    /**
     * the after execute command
     *
     * @param cmdRequest this cmd request
     */
    default void after(SmsCmdRequest cmdRequest) {
    }
}
