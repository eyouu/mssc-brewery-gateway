package com.whosaidmeow.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsscBreweryGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsscBreweryGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/googlesearch2")
                        .filters(f -> f.rewritePath("/googlesearch2(?<segment>/?.*)", "/${segment}"))
                        .uri("https://google.com"))
                .build();
    }
}
