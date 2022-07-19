package com.example.fluxboot.config;

import com.example.fluxboot.handle.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 配置访问路径
 */
@Configuration
public class WebFluxRoutingConfig {
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler){
        return RouterFunctions.route(
                RequestPredicates.GET("/user/all")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), userHandler::getUserAll).andRoute(RequestPredicates.GET("/user/{id}")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), userHandler::getUser);

    }
}
