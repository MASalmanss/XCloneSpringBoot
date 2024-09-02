package com.XCloneAppSpring.XCloneApp.dto.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UserResource {
    private UUID id; // kaldır
    private String username;
    //Fullname
    private String description;
    private Date created_time;// kaldır
}
