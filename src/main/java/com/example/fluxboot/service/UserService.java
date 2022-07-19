package com.example.fluxboot.service;

import com.example.fluxboot.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getUser(String uid);

    Flux<User> getUserAll();
}
