package com.example.fluxboot;

import com.example.fluxboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootTest
class FluxbootApplicationTests {

    @Test
    void contextLoads() {
        WebClient webClient = WebClient.create("http://localhost:8080");
        Mono<User> resp = webClient.get().uri("/flux/user").retrieve().bodyToMono(User.class);
        System.out.println(resp.block());
    }

}
