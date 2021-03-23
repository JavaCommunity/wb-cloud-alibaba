package com.wb.sign.component.command.ebao;

import com.timevale.esign.sdk.tech.bean.result.Result;
import com.timevale.esign.sdk.tech.service.AccountService;
import com.timevale.esign.sdk.tech.v3.client.ServiceClient;
import com.wb.sign.component.command.SignCommand;
import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.request.ebao.EBaoUpdatePersonAccountRequest;
import com.wb.sign.component.command.result.SignResult;
import com.wb.sign.component.command.result.ebao.EBaoUpdatePersonAccountResult;
import com.wb.sign.component.utils.EBaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SignEBaoUpdatePersonAccountCmd
 * @Package: com.wb.sign.component.command.ebao
 * @Description: the sign e bao update person account cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/23
 * @Version: 1.0
 */
@Component
public class SignEBaoUpdatePersonAccountCmd implements SignCommand {

    @Autowired
    private ServiceClient serviceClient;

    @Override
    public <T extends SignResult> T execute(SignRequest<T> signRequest) {
        EBaoUpdatePersonAccountRequest request = (EBaoUpdatePersonAccountRequest) signRequest;
        AccountService service = serviceClient.accountService();
        Result updateAccountResult = service.updateAccount(
                request.getAccountId(),
                request.getPersonBean(),
                request.getDelParamType());
        return (T) EBaoUtils.result(updateAccountResult, EBaoUpdatePersonAccountResult.class);
    }
}
