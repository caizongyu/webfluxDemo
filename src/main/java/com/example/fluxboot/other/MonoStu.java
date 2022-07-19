package com.example.fluxboot.other;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


public class MonoStu {
    public static void main(String[] args) {
        //init();
        //userMap();
        //userZip();
        userFlatmap();
    }

    /**
     *初始化方式
     */
    public static void init(){
        Mono.just(1).subscribe(System.out::println);
        Flux.just(-1,-2).subscribe(System.out::println);
        Integer[] arr = new Integer[]{3,4};
        Flux.fromArray(arr).subscribe(System.out::println);
        List<Integer> list = Arrays.asList(arr);
        Flux.fromIterable(list).subscribe(System.out::println);

        Flux.fromStream(list.stream()).subscribe(System.out::println);

    }

    public static void userMap(){
        Mono.just(1).map(one->{
            return String.valueOf(one+" map transfer");
        }).subscribe(System.out::println);
    }

    public static void userFlatmap(){
        Flux<Integer> flux1 = Flux.just(1,2);
        Flux<Integer> flux2  = Flux.just(3,4);
        Flux.zip(flux1, flux2).flatMap(one->{
            return Mono.just(one.getT1()+one.getT2());
        }).subscribe(System.out::println);
    }
    public static void userZip(){
        Flux<Integer> flux1 = Flux.just(1,2);
        Flux<Integer> flux2  = Flux.just(3,4);
        Flux.zip(flux1, flux2).subscribe(System.out::println);

    }

    public void contenxtSimple(){
        String key = "message";


    }
}

