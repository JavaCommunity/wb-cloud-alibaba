package com.wb.oss.component.request;

import com.wb.oss.component.response.GenericResponse;

import java.io.InputStream;

/**
 * @ClassName: GenericRequest
 * @Package: com.wb.oss.component.request
 * @Description: the generic request
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public abstract class GenericRequest<T extends GenericResponse> implements OssRequest<T> {

    //  the object content
    private InputStream objectContent;

    //  the object name
    private String objectName;

    //  the content type
    private String contentType;

    //  the content size
    private long size;

    //  the object id
    private String objectId;

    /**
     * constructs a new generic request
     */
    public GenericRequest() {
    }

    /**
     * constructs a new generic request with the specified object name and object content
     *
     * @param objectName    the object name
     * @param objectContent the object content
     */
    public GenericRequest(String objectName, InputStream objectContent) {
        this.objectName = objectName;
        this.objectContent = objectContent;
    }

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
