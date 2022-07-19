package com.example.fluxboot;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ViaStepTest {
    public Flux<Integer>  createOf3(){
        return Flux.just(1,2,3);
    }
    @Test
    public void test(){

    }

}
