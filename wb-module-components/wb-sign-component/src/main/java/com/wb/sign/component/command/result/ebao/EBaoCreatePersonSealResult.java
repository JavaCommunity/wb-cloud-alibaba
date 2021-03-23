package com.wb.sign.component.command.result.ebao;

import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: EBaoCreatePersonSealResult
 * @Package: com.wb.sign.component.command.result.ebao
 * @Description: the e bao create person seal result
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class EBaoCreatePersonSealResult extends SignResult {

    //  the seal data
    private String sealData;

    public String getSealData() {
        return sealData;
    }

    public void setSealData(String sealData) {
        this.sealData = sealData;
    }
}
