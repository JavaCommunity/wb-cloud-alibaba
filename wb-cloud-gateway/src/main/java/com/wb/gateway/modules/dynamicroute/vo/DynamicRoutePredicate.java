package com.wb.gateway.modules.dynamicroute.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName: DynamicRoutePredicate
 * @Package: com.wb.gateway.vo
 * @Description: the dynamic route predicate
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
@ApiModel(value = "dynamicRoutePredicate", description = "动态路由断言vo")
public class DynamicRoutePredicate implements Serializable {

    private static final long serialVersionUID = 2758872924192776414L;

    @ApiModelProperty("类型")
    private String name;

    @ApiModelProperty("断言参数")
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
