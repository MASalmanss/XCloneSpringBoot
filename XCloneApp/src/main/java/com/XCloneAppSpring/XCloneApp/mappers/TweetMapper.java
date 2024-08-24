package com.XCloneAppSpring.XCloneApp.mappers;

import com.XCloneAppSpring.XCloneApp.dto.request.TweetCreateDto;
import com.XCloneAppSpring.XCloneApp.dto.response.TweetResource;
import com.XCloneAppSpring.XCloneApp.entity.Tweet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface TweetMapper {
    TweetResource TweetToTweetResource(Tweet tweet);

    List<TweetResource> TweetListToTweetResourceList(List<Tweet> tweets);

    @Mapping(source =  "userId", target = "id")
    Tweet tweetCreateDtoToTweet(TweetCreateDto tweetCreateDto);
}
