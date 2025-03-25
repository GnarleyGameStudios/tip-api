package com.poketeam.api.controller.mapper;

import com.poketeam.api.controller.ro.NewUserRO;
import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    User mapToUser(NewUserRO newUserRO);

    UserRO mapToUserRO(User user);
}
