package com.wb.sign.component.command.result.ebao;

import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: EBaoCreatePersonAccountResult
 * @Package: com.wb.sign.component.result.ebao
 * @Description: the e bao create person account result
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class EBaoCreatePersonAccountResult extends SignResult {

    //  the fingerprint
    private String fingerprint;

    //  the account id
    private String accountId;

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
