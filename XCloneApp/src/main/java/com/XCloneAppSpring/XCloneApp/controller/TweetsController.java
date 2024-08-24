package com.XCloneAppSpring.XCloneApp.controller;

import com.XCloneAppSpring.XCloneApp.dto.response.TweetResource;
import com.XCloneAppSpring.XCloneApp.mappers.TweetMapper;
import com.XCloneAppSpring.XCloneApp.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tweets")
@RequiredArgsConstructor
public class TweetsController {

    private final TweetService tweetService;
    private final TweetMapper tweetMapper;

    @GetMapping("")
    public List<TweetResource> findAll(){

        var liste = tweetService.findAll();
        return  tweetMapper.TweetListToTweetResourceList(liste);

    }

    @GetMapping("{id}")
    public TweetResource findById(@PathVariable UUID id){
        var tweet = tweetService.findById(id);
        return tweetMapper.TweetToTweetResource(tweet);
    }
}
