package com.wb.sign.component.command.request.ebao;

import com.timevale.esign.sdk.tech.bean.UpdatePersonBean;
import com.timevale.esign.sdk.tech.impl.constants.DeleteParamType;
import com.wb.sign.component.command.request.SignGenericRequest;
import com.wb.sign.component.command.result.ebao.EBaoUpdatePersonAccountResult;
import com.wb.sign.component.utils.SignReqCheckUtils;

import java.util.List;

/**
 * @ClassName: EBaoUpdatePersonAccountRequest
 * @Package: com.wb.sign.component.command.request.ebao
 * @Description: the e bao update person account request
 * @Author：[bo.wang]
 * @Date: 2021/3/23
 * @Version: 1.0
 */
public class EBaoUpdatePersonAccountRequest extends SignGenericRequest<EBaoUpdatePersonAccountResult> {

    //  the account
    private String accountId;

    //  the delete param type
    private List<DeleteParamType> delParamType;

    //  the person bean
    private UpdatePersonBean personBean;

    @Override
    public void check() {
        SignReqCheckUtils.checkEmpty(accountId, "accountId");
        SignReqCheckUtils.checkEmpty(personBean, "personBean");
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<DeleteParamType> getDelParamType() {
        return delParamType;
    }

    public void setDelParamType(List<DeleteParamType> delParamType) {
        this.delParamType = delParamType;
    }

    public UpdatePersonBean getPersonBean() {
        return personBean;
    }

    public void setPersonBean(UpdatePersonBean personBean) {
        this.personBean = personBean;
    }
}
