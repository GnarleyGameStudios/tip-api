package com.poketeam.api.repository.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("user")
public class UserDO {
    private String username;
    private String password;
    private String email;
}
