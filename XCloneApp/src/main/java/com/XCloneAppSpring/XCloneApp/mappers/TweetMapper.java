package com.XCloneAppSpring.XCloneApp.mappers;

import com.XCloneAppSpring.XCloneApp.dto.request.TweetCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.TweetResource;
import com.XCloneAppSpring.XCloneApp.entity.Tweet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface TweetMapper {

    @Mapping(target = "fullname" , source = "user.fullname")
    @Mapping(target = "username" , source = "user.usernameData")
    @Mapping(target = "user_id" , source = "user.id")
    TweetResource TweetToTweetResource(Tweet tweet);

    List<TweetResource> TweetListToTweetResourceList(List<Tweet> tweets);

    Tweet tweetCreateDtoToTweet(TweetCreateDto tweetCreateDto);
}
