package com.XCloneAppSpring.XCloneApp.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class UserUpdateDto {
    private UUID id;// id
    private String fullname;// Fullname
    private String description;// description
}
