package com.wb.sign.component.command.ebao;

import com.timevale.esign.sdk.tech.bean.PersonBean;
import com.timevale.esign.sdk.tech.bean.result.AddAccountResult;
import com.timevale.esign.sdk.tech.service.AccountService;
import com.timevale.esign.sdk.tech.v3.client.ServiceClient;
import com.wb.sign.component.command.SignCommand;
import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.request.ebao.EBaoCreatePersonAccountRequest;
import com.wb.sign.component.command.result.SignResult;
import com.wb.sign.component.command.result.ebao.EBaoCreatePersonAccountResult;
import com.wb.sign.component.utils.EBaoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SignEBaoCreatePersonAccountCmd
 * @Package: com.wb.sign.component.command.ebao
 * @Description: the sign e bao create person account cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Component
public class SignEBaoCreatePersonAccountCmd implements SignCommand {

    @Autowired
    private ServiceClient serviceClient;

    @Override
    public <T extends SignResult> T execute(SignRequest<T> signRequest) {
        AccountService account = serviceClient.accountService();
        EBaoCreatePersonAccountRequest request = (EBaoCreatePersonAccountRequest) signRequest;
        PersonBean personBean = new PersonBean();
        BeanUtils.copyProperties(request, personBean);
        AddAccountResult addAccountResult = account.addAccount(personBean);
        return (T) EBaoUtils.result(addAccountResult, EBaoCreatePersonAccountResult.class);
    }
}
