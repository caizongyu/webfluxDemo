package com.example.fluxboot.controller;

import reactor.core.publisher.Mono;

public class MonoStu {
    public static void main(String[] args) {
        Mono.just(1).map(String::valueOf).subscribe(System.out::println);
    }
}
