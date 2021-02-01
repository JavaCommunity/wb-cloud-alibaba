package com.wb.oss.component.response.minio;

import com.wb.oss.component.response.OssResponse;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @ClassName: MinioGetResponse
 * @Package: com.wb.oss.component.response.minio
 * @Description: the minio get response
 * @Author：[bo.wang]
 * @Date: 2021/2/1
 * @Version: 1.0
 */
public class MinioGetResponse extends OssResponse implements Serializable {

    //  the object content
    private InputStream objectContent;

    /**
     * constructs a new minioGetResponse with the specified error code and error message
     *
     * @param errCode the error code
     * @param errMsg  the error message
     */
    public MinioGetResponse(String errCode, String errMsg) {
        this.setErrCode(errCode);
        this.setErrMsg(errMsg);
    }

    public InputStream getObjectContent() {
        return objectContent;
    }

    public void setObjectContent(InputStream objectContent) {
        this.objectContent = objectContent;
    }
}
