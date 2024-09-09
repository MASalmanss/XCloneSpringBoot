package com.XCloneAppSpring.XCloneApp.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class UserLoginResource {
    private String token;
    private UUID id;
}
