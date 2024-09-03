package com.XCloneAppSpring.XCloneApp.service;

import com.XCloneAppSpring.XCloneApp.dto.request.TweetLikedDto;
import com.XCloneAppSpring.XCloneApp.dto.request.TweetUpdateDto;
import com.XCloneAppSpring.XCloneApp.dto.request.UsersListTweetDto;
import com.XCloneAppSpring.XCloneApp.dto.response.TweetResource;
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

    public List<Tweet> getTweetsForUsers(UsersListTweetDto usersListTweetDto){
        Date oneHourAgo = new Date(System.currentTimeMillis() - 3600 * 1000);
        var result = tweetRepository.findTweetsByUserIdList(usersListTweetDto.getUuidList() , oneHourAgo);
       return result;
    }

    public Tweet updateTweetById(TweetUpdateDto tweetUpdateDto){
        Tweet tweet = tweetRepository.findById(tweetUpdateDto.getId()).orElseThrow(()-> new RuntimeException("Tweet not found exception"));
        tweet.setContent(tweetUpdateDto.getContent());
        return tweetRepository.save(tweet);

    }

    public void tweetLike(TweetLikedDto tweetLikedDto){
        Tweet tweet = tweetRepository.findById(tweetLikedDto.getId()).orElseThrow(()-> new RuntimeException("Tweet not found !"));
        var newValue = Math.max( 0 , tweet.getLiked_count() + (tweetLikedDto.getValue()));
        tweet.setLiked_count(newValue);
        tweetRepository.save(tweet);
    }
}
