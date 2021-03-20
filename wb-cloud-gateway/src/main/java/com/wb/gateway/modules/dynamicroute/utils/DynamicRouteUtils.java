package com.wb.gateway.modules.dynamicroute.utils;

import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteArgs;
import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteFilter;
import com.wb.gateway.modules.dynamicroute.vo.DynamicRoutePredicate;
import com.wb.gateway.modules.dynamicroute.vo.DynamicRouteVo;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: DynamicRouteUtils
 * @Package: com.wb.gateway.modules.dynamicroute.utils
 * @Description: the dynamic route utils
 * @Author：[bo.wang]
 * @Date: 2021/3/20
 * @Version: 1.0
 */
public class DynamicRouteUtils {

    /**
     * get route definition withe route vo.
     *
     * @param routeVo the route vo
     * @return the route definition
     */
    public static RouteDefinition getDefinition(DynamicRouteVo routeVo) {
        RouteDefinition definition = new RouteDefinition();
        definition.setId(routeVo.getId());
        definition.setOrder(routeVo.getOrder());
        definition.setUri(DynamicRouteUtils.getUri(routeVo.getUri()));
        definition.setPredicates(DynamicRouteUtils.getPredicates(routeVo));
        definition.setFilters(DynamicRouteUtils.getFilter(routeVo));
        return definition;
    }

    /**
     * get uri with the specified uri
     *
     * @param uri the uri
     * @return the URI
     */
    public static URI getUri(String uri) {
        Assert.hasText(uri, "'uri' must not be null！");

        return UriComponentsBuilder.fromHttpUrl(uri).build().toUri();
    }

    /**
     * get predicates with the specified route vo.
     *
     * @param routeVo the route vo
     * @return the predicate definition list
     */
    public static List<PredicateDefinition> getPredicates(DynamicRouteVo routeVo) {
        Assert.notNull(routeVo, "'routeVo' must not be null！");

        List<PredicateDefinition> predicateDefinitionList = new ArrayList<>();
        List<DynamicRoutePredicate> routePredicateList = routeVo.getPredicates();
        if (CollectionUtils.isEmpty(routePredicateList)) {
            return predicateDefinitionList;
        }
        routePredicateList.stream().forEach((predicate) -> {
            Set<DynamicRouteArgs> predicateArgs = predicate.getArgs();
            if (!CollectionUtils.isEmpty(predicateArgs)) {
                Map<String, String> predicateRuleMap = predicateArgs
                        .stream()
                        .collect(Collectors.toMap(DynamicRouteArgs::getKey, DynamicRouteArgs::getValue));
                PredicateDefinition predicateDefinition = new PredicateDefinition();
                predicateDefinition.setArgs(predicateRuleMap);
                predicateDefinition.setName(predicate.getName());
                predicateDefinitionList.add(predicateDefinition);
            }
        });
        return predicateDefinitionList;
    }

    /**
     * get filter with the specified route vo
     *
     * @param routeVo the route vo
     * @return the filter definition list
     */
    public static List<FilterDefinition> getFilter(DynamicRouteVo routeVo) {
        Assert.notNull(routeVo, "'routeVo' must not be null！");

        List<FilterDefinition> filterDefinitionList = new ArrayList<>();
        List<DynamicRouteFilter> routeFilters = routeVo.getFilters();
        if (CollectionUtils.isEmpty(routeFilters)) {
            return filterDefinitionList;
        }
        routeFilters.stream().forEach((filter) -> {
            Set<DynamicRouteArgs> filterArgs = filter.getArgs();
            if (!CollectionUtils.isEmpty(filterArgs)) {
                Map<String, String> filterRuleMap = filterArgs
                        .stream()
                        .collect(Collectors.toMap(DynamicRouteArgs::getKey, DynamicRouteArgs::getValue));
                FilterDefinition filterDefinition = new FilterDefinition();
                filterDefinition.setName(filter.getName());
                filterDefinition.setArgs(filterRuleMap);
                filterDefinitionList.add(filterDefinition);
            }
        });
        return filterDefinitionList;
    }
}
