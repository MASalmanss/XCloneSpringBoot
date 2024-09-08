package com.XCloneAppSpring.XCloneApp.controller;

import com.XCloneAppSpring.XCloneApp.dto.request.UserCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.request.UserUpdateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.TweetResource;
import com.XCloneAppSpring.XCloneApp.dto.response.UserResource;
import com.XCloneAppSpring.XCloneApp.dto.response.UserViewResource;
import com.XCloneAppSpring.XCloneApp.mappers.TweetMapper;
import com.XCloneAppSpring.XCloneApp.mappers.UsersMapper;
import com.XCloneAppSpring.XCloneApp.service.TweetService;
import com.XCloneAppSpring.XCloneApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class UserController {
    private final UserService userService;
    private final TweetService tweetService;
    private final TweetMapper tweetMapper;
    private final UsersMapper usersMapper;

    @PostMapping("")
    public UserResource create(@RequestBody UserCreateDto userCreateDto){
       var user = userService.createUser(userCreateDto);
       return usersMapper.userToUserresource(user);
    }

    @PutMapping("")
    private UserResource  updateByUserId(@RequestBody UserUpdateDto userUpdateDto){
       var user = userService.updateUserById(userUpdateDto);
       return usersMapper.userToUserresource(user);
    }

    @GetMapping("/{id}")
    public UserResource findById(@PathVariable UUID id){

        var user =  userService.getByIdUser(id);
        return usersMapper.userToUserresource(user);
    }

    @GetMapping("/{id}/tweets")
    public List<TweetResource> getTweets(@PathVariable UUID id){
       var tweets = tweetService.findAllByUserId(id);
       return tweetMapper.TweetListToTweetResourceList(tweets);
    }

    @PutMapping("/{userId}/follow/{followerId}")
    public ResponseEntity<Void> followUser(@PathVariable UUID userId , @PathVariable UUID followerId){
        userService.followUser(userId , followerId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/unfollow/{followerId}")
    public ResponseEntity<Void> unFollowUser(@PathVariable UUID userId , @PathVariable UUID followerId){
        userService.unFollowUser(userId , followerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/followings")
    public ResponseEntity<List<UserViewResource>> getFollowings(@PathVariable UUID id){
        var list = userService.getFollowings(id);
        var mappingList = usersMapper.userListToUserViewResourceList(list);
        return ResponseEntity.ok(mappingList);
    }

    @GetMapping("/{id}/followers")
    public ResponseEntity<List<UserViewResource>> getFollowers(@PathVariable UUID id){
        var list = userService.getFollowers(id);
        var mappingList = usersMapper.userListToUserViewResourceList(list);
        return ResponseEntity.ok(mappingList);
    }
}
