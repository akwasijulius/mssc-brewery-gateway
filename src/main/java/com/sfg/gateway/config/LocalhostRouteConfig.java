package com.sfg.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Julius Oduro on 18/04/2020.
 */
@Configuration
public class LocalhostRouteConfig {

    @Bean
    public RouteLocator localhostRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/api/v1/beer*", "/api/v1/beer/*")
                        .uri("http://localhost:8080")
                        .id("beer-service"))
                .route(r -> r.path("/api/v1/customers*", "/api/v1/customers/*")
                        .uri("http://localhost:8081")
                        .id("beer-order-service"))
                .build();
    }
}
