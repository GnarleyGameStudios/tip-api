package com.poketeam.api.service;

import com.poketeam.api.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UsersService {
    public Mono<User> createUser(User user) {
        // Business logic to create a user
        // For now, just return the user object wrapped in a Mono
        return Mono.just(user);
    }
}