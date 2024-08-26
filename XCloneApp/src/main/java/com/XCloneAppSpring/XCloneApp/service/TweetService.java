package com.XCloneAppSpring.XCloneApp.service;

import com.XCloneAppSpring.XCloneApp.dto.request.UsersListTweetDto;
import com.XCloneAppSpring.XCloneApp.entity.Tweet;
import com.XCloneAppSpring.XCloneApp.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Tweet> findAllByUserId(UUID id){
        return tweetRepository.findAllByUserId(id);
    }

    public Tweet createTweet(Tweet tweet){
        tweet.setLiked_count(0);
        return tweetRepository.save(tweet);
    }

    public List<Tweet> getTweetsForUsers(){
        List<UUID> uuidList = List.of();
        Date oneHourAgo = new Date(System.currentTimeMillis() - 3600 * 1000);
       return tweetRepository.findTweetsByUserIdList(uuidList , oneHourAgo);
    }
}
