package com.example.fluxboot.other;

import reactor.core.publisher.Mono;

public class WebFluxContext {
    public static void main(String[] args) {
        WebFluxContext webFluxContext = new WebFluxContext();
        webFluxContext.useWebContenxt();
    }
    public void useWebContenxt(){
        String key = "message";
        //contexnt作用从下往上，
        Mono.just("123").flatMap(s -> Mono.subscriberContext()
                .map(ctx -> s + "" + ctx.get(key)))
                .subscriberContext(ctx -> ctx.put(key, "world"))
                .subscribe(System.out::println);

    }
}
