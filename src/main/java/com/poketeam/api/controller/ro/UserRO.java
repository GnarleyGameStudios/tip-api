package com.poketeam.api.controller.ro;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRO {
    private final Long id;
    private final String username;
}
