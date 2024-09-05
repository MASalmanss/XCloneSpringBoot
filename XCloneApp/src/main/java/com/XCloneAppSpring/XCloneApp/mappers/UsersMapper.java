package com.XCloneAppSpring.XCloneApp.mappers;

import com.XCloneAppSpring.XCloneApp.dto.request.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.UserResource;
import com.XCloneAppSpring.XCloneApp.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface UsersMapper {

    Users userDtoToUsers(UserCreateDto userCreateDto);

    @Mapping(target = "followersCount" , expression = "java(users.getFollowers() !=null ? (long)users.getFollowers().size() : 0)")
    @Mapping(target = "followingCount" , expression = "java(users.getFollowing() !=null ? (long)users.getFollowing().size() : 0)")
    UserResource userToUserresource(Users users);
}
