package com.XCloneAppSpring.XCloneApp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TweetUpdateDto {
    private UUID id;
    private String content;
}
