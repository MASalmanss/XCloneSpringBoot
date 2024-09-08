package com.XCloneAppSpring.XCloneApp.controller;

import com.XCloneAppSpring.XCloneApp.dto.request.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.request.UserLoginDto;
import com.XCloneAppSpring.XCloneApp.dto.response.UserLoginResource;
import com.XCloneAppSpring.XCloneApp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserCreateDto userCreateDto){
        authenticationService.register(userCreateDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResource> login(@RequestBody UserLoginDto userLoginDto){
       UserLoginResource userLoginResource = authenticationService.login(userLoginDto);
       return ResponseEntity.ok(userLoginResource);
    }
}
