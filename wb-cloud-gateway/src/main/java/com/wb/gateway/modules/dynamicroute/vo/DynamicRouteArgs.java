package com.wb.gateway.modules.dynamicroute.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName: DynamicRouteArgs
 * @Package: com.wb.gateway.vo
 * @Description: the dynamic route args
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@ApiModel(value = "dynamicRouteArgs", description = "动态路由参数vo")
public class DynamicRouteArgs implements Serializable {

    private static final long serialVersionUID = -102362259799981208L;

    @ApiModelProperty("参数名称")
    private String key;

    @ApiModelProperty("参数值")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
