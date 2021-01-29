package com.wb.oss.component.request;

import com.wb.oss.component.response.OssResponse;

/**
 * @ClassName: BaseOssRequest
 * @Package: com.wb.oss.component.request
 * @Description: the base oss request
 * @Author：[bo.wang]
 * @Date: 2021/1/29
 * @Version: 1.0
 */
public abstract class BaseOssRequest<T extends OssResponse> implements OssRequest<T> {

}
