package com.poketeam.api.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class User {
    private final Long id;
    private final String username;
    private final String password;
    private final String email;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastLoginDateTime;
}
