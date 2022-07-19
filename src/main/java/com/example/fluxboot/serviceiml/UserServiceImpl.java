package com.example.fluxboot.serviceiml;

import com.example.fluxboot.entity.User;
import com.example.fluxboot.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
@Service
public class UserServiceImpl implements UserService {
    private static HashMap<String, User> map = new HashMap<>();
    static{
        map.put("1", new User("name1","17"));
        map.put("2",new User("name2", "18"));
        map.put("3", new User("name3", "19"));
    }

    @Override
    public Mono<User> getUser(String uid) {
        return Mono.just(map.get(uid));
    }

    @Override
    public Flux<User> getUserAll() {
        return Flux.fromIterable(map.values());
    }
}
