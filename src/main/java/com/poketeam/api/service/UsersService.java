package com.poketeam.api.service;

import com.poketeam.api.controller.ro.NewUserRO;
import com.poketeam.api.model.User;
import com.poketeam.api.model.mapper.UsersMapper;
import com.poketeam.api.model.request.NewUserRORequest;
import com.poketeam.api.model.response.ApiResponseWrapper;
import com.poketeam.api.model.response.CreateUserResponse;
import com.poketeam.api.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    private final UserRepository userRepository;

//    public Mono<User> createUser(User user) {
//        return userRepository.save(user);
//    }

    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<ApiResponseWrapper<CreateUserResponse>> createUser(@Valid NewUserRORequest newUserRORequest) {
        NewUserRO newUserRO = usersMapper.mapToNewUserRO(newUserRORequest);

        return userRepository.findByUsername(newUserRO.getUsername()).flatMap(existingUser -> {
            return Mono.just(new ApiResponseWrapper<CreateUserResponse>(HttpStatus.CONFLICT.value(), "User already exists", null));
        }).switchIfEmpty(userRepository.save(usersMapper.mapToUser(newUserRO)).map(user -> new ApiResponseWrapper<>(HttpStatus.CREATED.value(), "User created successfully", new CreateUserResponse(user.getEmail(), user.getUsername()))));
    }
}