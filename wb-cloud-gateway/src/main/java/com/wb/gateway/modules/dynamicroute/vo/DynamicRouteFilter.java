package com.wb.gateway.modules.dynamicroute.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName: DynamicRouteFilter
 * @Package: com.wb.gateway.vo
 * @Description: the dynamic route filter
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@ApiModel(value = "dynamicRouteFilter", description = "动态路由过滤器vo")
public class DynamicRouteFilter implements Serializable {

    private static final long serialVersionUID = -4294784214875129393L;

    @ApiModelProperty("类型")
    private String name;

    @ApiModelProperty("参数")
    private Set<DynamicRouteArgs> args;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DynamicRouteArgs> getArgs() {
        return args;
    }

    public void setArgs(Set<DynamicRouteArgs> args) {
        this.args = args;
    }
}
