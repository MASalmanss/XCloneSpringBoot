package com.XCloneAppSpring.XCloneApp.mappers;

import com.XCloneAppSpring.XCloneApp.dto.request.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.UserResource;
import com.XCloneAppSpring.XCloneApp.dto.response.UserViewResource;
import com.XCloneAppSpring.XCloneApp.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UsersMapper {

    @Mapping(source = "username" , target = "usernameData")
    Users userDtoToUsers(UserCreateDto userCreateDto);

    @Mapping(target = "followersCount" , expression = "java(users.getFollowers() !=null ? (long)users.getFollowers().size() : 0)")
    @Mapping(target = "followingCount" , expression = "java(users.getFollowing() !=null ? (long)users.getFollowing().size() : 0)")
    @Mapping(source = "usernameData" , target = "username")
    UserResource userToUserresource(Users users);

    @Mapping(source = "usernameData" , target = "username")
    UserViewResource userToUserViewResource(Users users);

    List<UserViewResource> userListToUserViewResourceList(List<Users> users);
}
