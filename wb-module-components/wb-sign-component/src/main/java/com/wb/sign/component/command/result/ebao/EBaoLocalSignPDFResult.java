package com.wb.sign.component.command.result.ebao;

import com.wb.sign.component.command.result.SignResult;

/**
 * @ClassName: EBaoLocalSignPDFResult
 * @Package: com.wb.sign.component.command.result.ebao
 * @Description: the e bao local sign pdf result
 * @Author：[bo.wang]
 * @Date: 2021/3/22
 * @Version: 1.0
 */
public class EBaoLocalSignPDFResult extends SignResult {

    //  the stream
    private byte[] stream;

    //  the sign detail url
    private String signDetailUrl;

    //  the sign service id
    private String signServiceId;

    //  the file path
    private String filePath;

    //  the dst file path
    private String dstFilePath;

    public byte[] getStream() {
        return stream;
    }

    public void setStream(byte[] stream) {
        this.stream = stream;
    }

    public String getSignDetailUrl() {
        return signDetailUrl;
    }

    public void setSignDetailUrl(String signDetailUrl) {
        this.signDetailUrl = signDetailUrl;
    }

    public String getSignServiceId() {
        return signServiceId;
    }

    public void setSignServiceId(String signServiceId) {
        this.signServiceId = signServiceId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDstFilePath() {
        return dstFilePath;
    }

    public void setDstFilePath(String dstFilePath) {
        this.dstFilePath = dstFilePath;
    }
}
