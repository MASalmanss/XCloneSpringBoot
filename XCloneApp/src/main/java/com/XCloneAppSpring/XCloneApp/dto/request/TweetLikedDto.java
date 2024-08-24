package com.XCloneAppSpring.XCloneApp.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class TweetLikedDto {
    private UUID id;
    private int value;
}
