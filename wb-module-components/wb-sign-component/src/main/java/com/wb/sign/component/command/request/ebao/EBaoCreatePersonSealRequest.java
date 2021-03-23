package com.wb.sign.component.command.request.ebao;

import com.timevale.esign.sdk.tech.bean.seal.PersonTemplateType;
import com.timevale.esign.sdk.tech.bean.seal.SealColor;
import com.wb.sign.component.command.request.SignGenericRequest;
import com.wb.sign.component.command.result.ebao.EBaoCreatePersonSealResult;
import com.wb.sign.component.utils.SignReqCheckUtils;

/**
 * @ClassName: EBaoCreatePersonSealRequest
 * @Package: com.wb.sign.component.command.request.ebao
 * @Description: the e bao create person seal request
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class EBaoCreatePersonSealRequest extends SignGenericRequest<EBaoCreatePersonSealResult> {

    //  the account id
    private String accountId;

    //  the template type
    private PersonTemplateType templateType;

    //  the color
    private SealColor color;

    @Override
    public void check() {
        SignReqCheckUtils.checkEmpty(accountId, "accountId");
        SignReqCheckUtils.checkEmpty(templateType, "templateType");
        SignReqCheckUtils.checkEmpty(color, "color");
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public PersonTemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(PersonTemplateType templateType) {
        this.templateType = templateType;
    }

    public SealColor getColor() {
        return color;
    }

    public void setColor(SealColor color) {
        this.color = color;
    }
}
