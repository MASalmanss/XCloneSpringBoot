package com.XCloneAppSpring.XCloneApp.mappers;

import com.XCloneAppSpring.XCloneApp.dto.request.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.UserResource;
import com.XCloneAppSpring.XCloneApp.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UsersMapper {

    Users userDtoToUsers(UserCreateDto userCreateDto);

    UserResource userToUserresource(Users users);
}
