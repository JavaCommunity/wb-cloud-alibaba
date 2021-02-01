package com.wb.oss.component.response.minio;

import com.wb.oss.component.response.OssResponse;

/**
 * @ClassName: MinioRemoveResponse
 * @Package: com.wb.oss.component.response.minio
 * @Description: the minio remove response
 * @Author：[bo.wang]
 * @Date: 2021/2/1
 * @Version: 1.0
 */
public class MinioRemoveResponse extends OssResponse {

    /**
     * constructs a new minioRemoveResponse with the specified error code and error message
     *
     * @param errCode the error code
     * @param errMsg  the error message
     */
    public MinioRemoveResponse(String errCode, String errMsg) {
        this.setErrCode(errCode);
        this.setErrMsg(errMsg);
    }
}
