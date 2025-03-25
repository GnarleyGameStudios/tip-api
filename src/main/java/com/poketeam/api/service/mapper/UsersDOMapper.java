package com.poketeam.api.service.mapper;

import com.poketeam.api.model.User;
import com.poketeam.api.repository.dto.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersDOMapper {

    @Mapping(target = "user_name", source = "username")
    @Mapping(target = "user_id", source = "id")
    UserDO mapToUserDO(User user);

    @Mapping(target = "username", source = "user_name")
    @Mapping(target = "id", source = "user_id")
    User mapToUser(UserDO userDO);
}
