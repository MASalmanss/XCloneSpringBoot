package com.XCloneAppSpring.XCloneApp.repository;

import com.XCloneAppSpring.XCloneApp.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TweetRepository extends JpaRepository<Tweet , UUID> {
    List<Tweet> findAllByUserId(UUID uuid);

    @Query("SELECT t FROM Tweet t WHERE t.user.id IN :userIds AND t.created_time >= :oneHourAgo ORDER BY t.created_time ASC")
    List<Tweet> findTweetsByUserIdList(@Param("userIds") List<UUID> userIds, @Param("oneHourAgo") Date oneHourAgo);

    //



}
