package com.XCloneAppSpring.XCloneApp.service;

import com.XCloneAppSpring.XCloneApp.dto.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.entity.Users;
import com.XCloneAppSpring.XCloneApp.mappers.UsersMapper;
import com.XCloneAppSpring.XCloneApp.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UsersMapper usersMapper;
    public Users createUser(UserCreateDto userCreateDto){
        var user = usersMapper.userDtoToUsers(userCreateDto);
        return userRepository.save(user);
    }
}
