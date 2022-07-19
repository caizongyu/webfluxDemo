package com.example.fluxboot.handle;

import com.example.fluxboot.entity.User;
import com.example.fluxboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *  把调用转化成Mono<ServerResponse>
 *
 */
@Component
public class UserHandler {
    @Autowired
    private UserService userService;


    public Mono<ServerResponse> getUser(ServerRequest serverRequest){
        String userid = serverRequest.pathVariable("id");
        Mono<User>  userMono = userService.getUser(userid);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userMono, User.class);


    }

    public Mono<ServerResponse> getUserAll(ServerRequest serverRequest){
        Flux<User> userFlux = userService.getUserAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userFlux, User.class);
    }
}
