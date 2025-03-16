package com.poketeam.api.controller;

import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public Mono<UserRO> createUser(@RequestBody UserRO user) {
        return Mono.just(user);
    }
}
