package com.wb.sign.component.command.ebao;

import com.timevale.esign.sdk.tech.bean.result.AddSealResult;
import com.timevale.esign.sdk.tech.service.SealService;
import com.timevale.esign.sdk.tech.v3.client.ServiceClient;
import com.wb.sign.component.command.SignCommand;
import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.request.ebao.EBaoCreatePersonSealRequest;
import com.wb.sign.component.command.result.SignResult;
import com.wb.sign.component.command.result.ebao.EBaoCreatePersonSealResult;
import com.wb.sign.component.utils.EBaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SignEBaoCreatePersonSealCmd
 * @Package: com.wb.sign.component.command.ebao
 * @Description: the sign e bao create person seal cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Component
public class SignEBaoCreatePersonSealCmd implements SignCommand {

    @Autowired
    private ServiceClient serviceClient;

    @Override
    public <T extends SignResult> T execute(SignRequest<T> signRequest) {
        EBaoCreatePersonSealRequest request = (EBaoCreatePersonSealRequest) signRequest;
        SealService sealService = serviceClient.sealService();
        AddSealResult addSealResult = sealService.addTemplateSeal(
                request.getAccountId(),
                request.getTemplateType(),
                request.getColor()
        );
        return (T) EBaoUtils.result(addSealResult, EBaoCreatePersonSealResult.class);
    }
}
