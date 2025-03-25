package com.poketeam.api.controller.ro;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NewUserRO {
    private final String username;
    private final String password;
    @Nullable
    private final String email;
}
