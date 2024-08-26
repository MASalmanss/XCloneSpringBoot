package com.XCloneAppSpring.XCloneApp.dto.request;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UsersListTweetDto {
    List<UUID> uuidList;
}
