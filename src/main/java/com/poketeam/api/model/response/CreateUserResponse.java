package com.poketeam.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor  // Automatically creates a constructor with email and username
public class CreateUserResponse {
    private String email;
    private String username;
}
