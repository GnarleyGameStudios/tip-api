package com.poketeam.api.model.mapper;

import com.poketeam.api.controller.ro.NewUserRO;
import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.model.User;
import com.poketeam.api.model.request.NewUserRORequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    User mapToUser(NewUserRO newUserRO);

    @Mapping(target = "id", source = "userId")
    UserRO mapToUserRO(User user);


    // Mapping from UserRO to User
    @Mapping(target = "userId", source = "id")
    User mapUserROToUser(UserRO userRO);

    NewUserRO mapToNewUserRO(NewUserRORequest newUserRORequest);
}
