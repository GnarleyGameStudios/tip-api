package com.poketeam.api.controller;

import com.poketeam.api.controller.mapper.UsersMapper;
import com.poketeam.api.controller.ro.NewUserRO;
import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersMapper usersMapper;
    private final UsersService usersService;

    @PostMapping()
    public Mono<UserRO> createUser(@RequestBody NewUserRO newUserRO) {
        return usersService.createUser(usersMapper.mapToUser(newUserRO))
                .map(usersMapper::mapToUserRO);
    }

    //TODO: Implement the following methods JENNY
    @GetMapping("/{id}")
    public Mono<UserRO> getUserById(@PathVariable("id") Long id) {
        return Mono.just(UserRO.builder().id(id).username("user").build());
    }

    //TODO: Implement the following methods (DO NOT RETURN PASSWORDS) TERRY
    @GetMapping()
    public Mono<UserRO> getUserByUsername(@RequestParam("username") String username) {
        return Mono.just(UserRO.builder().username(username).build());
    }

    //TODO: Implement the method to get ALL users (DO NOT RETURN PASSWORDS) JENNY
}
