package com.XCloneAppSpring.XCloneApp.dto.request;

import lombok.Data;

@Data
public class UserCreateDto {
    private String username;
    private String fullname;//fulname
   // private String description; // kaldır
    private String password;//password
   private String email; //email
}




