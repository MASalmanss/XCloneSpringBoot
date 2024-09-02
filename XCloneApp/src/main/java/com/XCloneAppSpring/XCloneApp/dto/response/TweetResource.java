package com.XCloneAppSpring.XCloneApp.dto.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TweetResource {
    private UUID id;      //kaldır
    private UUID user_id;        //kaldır
    private String fullname;//fulname
    private String username;//username
    private String content;
    private Date created_time;
    private Integer liked_count;
}
