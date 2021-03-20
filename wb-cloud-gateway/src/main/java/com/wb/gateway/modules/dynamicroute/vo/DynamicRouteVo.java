package com.wb.gateway.modules.dynamicroute.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: DynamicRouteVo
 * @Package: com.wb.gateway.vo
 * @Description: the dynamic route vo
 * @Author：[bo.wang]
 * @Date: 2021/3/19
 * @Version: 1.0
 */
@ApiModel(value = "dynamicRouteVo", description = "动态路由vo")
public class DynamicRouteVo implements Serializable {

    private static final long serialVersionUID = -3192465268065185968L;

    @ApiModelProperty("路由ID,唯一标识")
    private String id;

    @ApiModelProperty("路由url地址")
    private String uri;

    @ApiModelProperty("路由排序，默认0")
    private Integer order = 0;

    @ApiModelProperty("路由断言")
    private List<DynamicRoutePredicate> predicates;

    @ApiModelProperty("路由过滤器")
    private List<DynamicRouteFilter> filters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<DynamicRoutePredicate> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<DynamicRoutePredicate> predicates) {
        this.predicates = predicates;
    }

    public List<DynamicRouteFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<DynamicRouteFilter> filters) {
        this.filters = filters;
    }
}
