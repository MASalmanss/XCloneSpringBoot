package com.XCloneAppSpring.XCloneApp.controller;

import com.XCloneAppSpring.XCloneApp.dto.request.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.UserResource;
import com.XCloneAppSpring.XCloneApp.entity.Users;
import com.XCloneAppSpring.XCloneApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public UserResource create(@RequestBody UserCreateDto userCreateDto){
       return userService.createUser(userCreateDto);
    }

    @GetMapping("{id}")
    public UserResource findById(@PathVariable UUID id){
       return userService.getByIdUser(id);
    }
}
