package com.poketeam.api.model.mapper;

import com.poketeam.api.controller.ro.NewUserRO;
import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(target = "user_name", source = "username")
    User mapToUser(NewUserRO newUserRO);

    @Mapping(target = "username", source = "user_name")
    @Mapping(target = "id", source = "user_id")
    UserRO mapToUserRO(User user);
}
