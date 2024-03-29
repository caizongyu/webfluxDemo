package com.example.fluxboot.other;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;


public class MonoStu {
    public static String record = "";
    public static void main(String[] args) {
        //init();
        //userMap();
        //userZip();
        //userFlatmap();
        userHandle();
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

    /**
     * 多个操作，指定操作完成，就返回，没有完成的操作就丢弃
     */
    public static void userHandle() {
        Mono<String> mono5 = Mono.just("").map(s -> {
            try {
                Thread.sleep(2000);
                record += "mono5/";
                System.out.println("mono5 is over");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "5";
        }).subscribeOn(Schedulers.boundedElastic());

        Mono<String> mono10 = Mono.just(10).map(s->{
            try {
                Thread.sleep(4000);
                record+= "mono10";
                System.out.println("mono10 is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "10";
        }).subscribeOn(Schedulers.boundedElastic());

        Mono<String> mono15 = Mono.just(15).map(s->{
            try {
                Thread.sleep(6000);
                record += "mode15";
                System.out.println("mono15 is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "15";
        }).subscribeOn(Schedulers.boundedElastic());

        Mono<Object> single = Flux.merge(mono5, mono10,mono15).handle(((s, synchronousSink) ->{
            if("10".equals(s)){

                synchronousSink.next( "zj 牛逼 ");
                synchronousSink.complete();
            }
        })).defaultIfEmpty("null").single();
        System.out.println("-----");
        single.subscribe(System.out::println);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}

