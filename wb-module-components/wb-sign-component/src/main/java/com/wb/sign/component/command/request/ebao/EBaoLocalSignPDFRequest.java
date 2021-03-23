package com.wb.sign.component.command.request.ebao;

import com.timevale.esign.sdk.tech.bean.PosBean;
import com.timevale.esign.sdk.tech.bean.SignPDFFileBean;
import com.timevale.esign.sdk.tech.impl.constants.SignType;
import com.wb.sign.component.command.request.SignGenericRequest;
import com.wb.sign.component.command.result.ebao.EBaoLocalSignPDFResult;
import com.wb.sign.component.utils.SignReqCheckUtils;

/**
 * @ClassName: EBaoLocalSignPDFRequest
 * @Package: com.wb.sign.component.command.request.ebao
 * @Description: the e bao local sign pdf request
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class EBaoLocalSignPDFRequest extends SignGenericRequest<EBaoLocalSignPDFResult> {

    //  the account id
    private String accountId;

    //  the sign type
    private SignType signType;

    //  the seal data
    private String sealData;

    //  the pdf file bean
    private SignPDFFileBean pdfFileBean;

    //  the pos bean
    private PosBean posBean;

    @Override
    public void check() {
        SignReqCheckUtils.checkEmpty(accountId, "accountId");
        SignReqCheckUtils.checkEmpty(signType, "signType");
        SignReqCheckUtils.checkEmpty(pdfFileBean, "pdfFileBean");
        SignReqCheckUtils.checkEmpty(posBean, "posBean");
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public SignType getSignType() {
        return signType;
    }

    public void setSignType(SignType signType) {
        this.signType = signType;
    }

    public String getSealData() {
        return sealData;
    }

    public void setSealData(String sealData) {
        this.sealData = sealData;
    }

    public SignPDFFileBean getPdfFileBean() {
        return pdfFileBean;
    }

    public void setPdfFileBean(SignPDFFileBean pdfFileBean) {
        this.pdfFileBean = pdfFileBean;
    }

    public PosBean getPosBean() {
        return posBean;
    }

    public void setPosBean(PosBean posBean) {
        this.posBean = posBean;
    }
}
