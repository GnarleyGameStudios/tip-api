package com.poketeam.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class User {
    @Id
    @Column("user_id")
    private Long userId;
    @Column("user_name")
    private String username;
    private String password;
    private String email;
}
