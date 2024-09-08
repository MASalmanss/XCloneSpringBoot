package com.XCloneAppSpring.XCloneApp.service;

import com.XCloneAppSpring.XCloneApp.dto.request.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.request.UserLoginDto;
import com.XCloneAppSpring.XCloneApp.dto.response.UserLoginResource;
import com.XCloneAppSpring.XCloneApp.entity.Users;
import com.XCloneAppSpring.XCloneApp.repository.UserRepository;
import com.XCloneAppSpring.XCloneApp.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void register(UserCreateDto userCreateDto){
        Optional<Users> user = userRepository.findByEmail(userCreateDto.getEmail());
        if(user.isEmpty()){
            Users users = new Users();
            users.setFullname(userCreateDto.getFullname());
            users.set_active(true);
            users.setUsername(userCreateDto.getUsername());
            users.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
            users.setEmail(userCreateDto.getEmail());
            userRepository.save(users);
        }

    }

    public UserLoginResource login(UserLoginDto userLoginDto){
        Optional<Users> user = userRepository.findByEmail(userLoginDto.getEmail());
        if(user.isPresent()){
            if(passwordEncoder.matches(user.get().getPassword() , userLoginDto.getPassword())){
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        userLoginDto.getEmail(),userLoginDto.getPassword()
                ));
                UserLoginResource userLoginResource = new UserLoginResource();
                String token = jwtService.generateToken(user.get());
                userLoginResource.setToken(token);
                return userLoginResource;
            }
        }
        throw new RuntimeException("User not found");
    }
}
