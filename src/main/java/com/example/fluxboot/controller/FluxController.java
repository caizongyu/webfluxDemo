package com.example.fluxboot.controller;

import com.example.fluxboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flux")
public class FluxController {
    @GetMapping("/hello")
    public String hello(){
        return "hello flux";
    }

    @GetMapping("/user")
    public Mono<User> getUser(){
        User user = new User();
        user.setName("czy");
        return Mono.just(user);
    }
}
