package com.XCloneAppSpring.XCloneApp.service;

import com.XCloneAppSpring.XCloneApp.entity.Tweet;
import com.XCloneAppSpring.XCloneApp.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;

    public List<Tweet> findAll(){
        return tweetRepository.findAll();
    }

    public Tweet findById(UUID id){
        return tweetRepository.findById(id).orElseThrow(()-> new RuntimeException("Boyle bir kayit yok !"));
    }
}
