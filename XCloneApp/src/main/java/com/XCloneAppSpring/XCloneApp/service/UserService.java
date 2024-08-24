package com.XCloneAppSpring.XCloneApp.service;

import com.XCloneAppSpring.XCloneApp.dto.request.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.UserResource;
import com.XCloneAppSpring.XCloneApp.entity.Users;
import com.XCloneAppSpring.XCloneApp.mappers.UsersMapper;
import com.XCloneAppSpring.XCloneApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UsersMapper usersMapper;

    public UserResource createUser(UserCreateDto userCreateDto){
        var user = usersMapper.userDtoToUsers(userCreateDto);
        user.set_active(true);
        userRepository.save(user);
        return usersMapper.userToUserresource(user);
    }

    public UserResource getByIdUser(UUID id){
        var users = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found !"));
        if(users.is_active()){
            return usersMapper.userToUserresource(users);
        }
        throw new RuntimeException("User not found !");
    }
}
