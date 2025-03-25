package com.poketeam.api.service;

import com.poketeam.api.model.User;
import com.poketeam.api.repository.UserRepository;
import com.poketeam.api.service.mapper.UsersDOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersDOMapper usersDOMapper;
    private final UserRepository userRepository;

    public Mono<User> createUser(User user) {
        return userRepository.save(usersDOMapper.mapToUserDO(user))
                .map(usersDOMapper::mapToUser);
    }
}