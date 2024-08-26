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

    @Query("select t from Tweet t where t.user.id In :UserIds and t.created_time >= :OneHourAgo order by t.created_time asc ")
    List<Tweet> findTweetsByUserIdList(@Param("UserIds") List<UUID> list , @Param("OneHourAgo") Date oneHourAgo);
}
