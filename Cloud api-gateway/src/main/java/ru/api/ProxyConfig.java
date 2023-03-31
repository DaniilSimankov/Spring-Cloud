package ru.api;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
class ProxyConfig {

    // courses-management/courses ->

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("courses-route",
                        route -> route.path("/courses-management/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://courses-service")) //lb - load balanced - распределение нагрузки между несколькими запущенными сервисами
                .route("users-route",
                        route -> route.path("/users-management/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://users-service"))
                .route("education-route",
                        route -> route.path("/education-management/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://education-service"))
                .build();
    }
}

