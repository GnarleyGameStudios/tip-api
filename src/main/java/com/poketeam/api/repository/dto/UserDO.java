package com.poketeam.api.repository.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class UserDO {
    @Id
    private Long user_id;
    private String user_name;
    private String password;
    private String email;
}
