package com.wb.sign.component.command.request;

import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: SignGenericRequest
 * @Package: com.wb.sign.component.request
 * @Description: the sign generic request
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class SignGenericRequest<T extends SignResult> implements SignRequest<T> {

    //  the action
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
