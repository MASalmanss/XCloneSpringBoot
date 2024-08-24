package com.XCloneAppSpring.XCloneApp.dto.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TweetResource {
    private UUID id;
    private UUID user_id;
    private String content;
    private Date created_time;
    private Integer liked_count;
}
