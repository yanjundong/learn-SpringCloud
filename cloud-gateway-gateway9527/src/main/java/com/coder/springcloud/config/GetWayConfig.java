package com.coder.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : JQK
 * @date : 2020-07-29 10:04
 * @description :
 */
@Configuration
public class GetWayConfig {

    @Bean
    public RouteLocator getRouterLocator(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_guonei",
                route -> route.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

}
