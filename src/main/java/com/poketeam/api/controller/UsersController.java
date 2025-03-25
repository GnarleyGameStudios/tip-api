package com.poketeam.api.controller;

import com.poketeam.api.controller.mapper.UsersMapper;
import com.poketeam.api.controller.ro.NewUserRO;
import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.poketeam.api.model.User;

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

    //TODO: Implement the following methods
    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable("id") Long id) {
        return Mono.just(User.builder().id(id).username("user").password("password").email("fakemail@email.com").build());
    }

    //TODO: Implement the following methods
    @GetMapping()
    public Mono<User> getUserByUsername(@RequestParam("username") String username) {
        return Mono.just(User.builder().username(username).password("password").email("fakemail@email.com").build());
    }
}
