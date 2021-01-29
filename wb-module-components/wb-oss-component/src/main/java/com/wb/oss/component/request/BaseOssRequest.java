package com.wb.oss.component.request;

import com.wb.oss.component.response.OssResponse;

import java.io.InputStream;

/**
 * @ClassName: BaseOssRequest
 * @Package: com.wb.oss.component.request
 * @Description: the base oss request
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public abstract class BaseOssRequest<T extends OssResponse> implements OssRequest<T> {

    //  the object content
    private InputStream objectContent;

    //  the object name
    private String objectName;

    public InputStream getObjectContent() {
        return objectContent;
    }

    public void setObjectContent(InputStream objectContent) {
        this.objectContent = objectContent;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
