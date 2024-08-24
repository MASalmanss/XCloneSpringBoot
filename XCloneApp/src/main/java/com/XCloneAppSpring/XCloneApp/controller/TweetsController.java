package com.XCloneAppSpring.XCloneApp.controller;

import com.XCloneAppSpring.XCloneApp.dto.request.TweetCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.TweetResource;
import com.XCloneAppSpring.XCloneApp.mappers.TweetMapper;
import com.XCloneAppSpring.XCloneApp.service.TweetService;
import com.XCloneAppSpring.XCloneApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tweets")
@RequiredArgsConstructor
public class TweetsController {

    private final TweetService tweetService;
    private final TweetMapper tweetMapper;
    private final UserService userService;

    @GetMapping("")
    public List<TweetResource> findAll(){

        var liste = tweetService.findAll();
        return  tweetMapper.TweetListToTweetResourceList(liste);

    }

    @GetMapping("/{id}")
    public TweetResource findById(@PathVariable UUID id){
        var tweet = tweetService.findById(id);
        return tweetMapper.TweetToTweetResource(tweet);
    }

    @PostMapping("")
    public TweetResource createTweet(@RequestBody TweetCreateDto tweetCreateDto){
       var tweet = tweetMapper.tweetCreateDtoToTweet(tweetCreateDto);
       tweet.setUser(userService.getByIdUser(tweetCreateDto.getUserId()));
       tweetService.createTweet(tweet);
       return tweetMapper.TweetToTweetResource(tweet);
    }
}
