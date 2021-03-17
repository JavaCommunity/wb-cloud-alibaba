package com.wb.sms.component.command.request;

/**
 * @ClassName: SmsGenericCmdRequest
 * @Package: com.wb.sms.component.command.request
 * @Description: the sms generic request
 * @Author：[bo.wang]
 * @Date: 2021/3/11
 * @Version: 1.0
 */
public class SmsGenericCmdRequest<T> implements SmsCmdRequest<T> {

    //  the action
    protected String action;

    /**
     * constructs a new sms generic cmd request with the action.
     *
     * @param action the action
     */
    public SmsGenericCmdRequest(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
