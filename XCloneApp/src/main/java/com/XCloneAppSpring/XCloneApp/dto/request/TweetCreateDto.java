package com.XCloneAppSpring.XCloneApp.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class TweetCreateDto {
    private UUID userId;
    private String content;

}
