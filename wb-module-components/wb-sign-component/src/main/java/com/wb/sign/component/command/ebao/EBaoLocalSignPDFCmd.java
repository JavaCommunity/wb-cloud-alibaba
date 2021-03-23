package com.wb.sign.component.command.ebao;

import com.timevale.esign.sdk.tech.bean.result.FileDigestSignResult;
import com.timevale.esign.sdk.tech.service.UserSignService;
import com.timevale.esign.sdk.tech.v3.client.ServiceClient;
import com.wb.sign.component.command.SignCommand;
import com.wb.sign.component.command.request.SignRequest;
import com.wb.sign.component.command.request.ebao.EBaoLocalSignPDFRequest;
import com.wb.sign.component.command.result.SignResult;
import com.wb.sign.component.command.result.ebao.EBaoLocalSignPDFResult;
import com.wb.sign.component.utils.EBaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: EBaoLocalSignPDFCmd
 * @Package: com.wb.sign.component.command.ebao
 * @Description: the e bao local sign pdf cmd
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
@Component
public class EBaoLocalSignPDFCmd implements SignCommand {

    @Autowired
    private ServiceClient serviceClient;

    @Override
    public <T extends SignResult> T execute(SignRequest<T> signRequest) {
        EBaoLocalSignPDFRequest request = (EBaoLocalSignPDFRequest) signRequest;
        UserSignService userSignService = serviceClient.userSignService();
        FileDigestSignResult fileDigestSignResult = userSignService.localSignPDF(
                request.getAccountId(),
                request.getSealData(),
                request.getPdfFileBean(),
                request.getPosBean(),
                request.getSignType()
        );
        return (T) EBaoUtils.result(fileDigestSignResult, EBaoLocalSignPDFResult.class);
    }
}
