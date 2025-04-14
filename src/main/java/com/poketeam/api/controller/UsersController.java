package com.poketeam.api.controller;

import com.poketeam.api.model.mapper.UsersMapper;
import com.poketeam.api.controller.ro.NewUserRO;
import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping("/{id}")
    public Mono<UserRO> getUserById(@PathVariable("id") Long id) {
        return usersService.getUserById(id)
                .map(usersMapper::mapToUserRO);
    }

    @GetMapping(params = "username")
    public Mono<UserRO> getUserByUsername(@RequestParam("username") String username) {
        return usersService.getUserByUsername(username)
                .map(usersMapper::mapToUserRO);
    }

    @GetMapping()
    public Flux<UserRO> getAllUsers() {
        return usersService.getAllUsers()
                .map(usersMapper::mapToUserRO);
    }
}
