package com.XCloneAppSpring.XCloneApp.repository;

import com.XCloneAppSpring.XCloneApp.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TweetRepository extends JpaRepository<Tweet , UUID> {
    List<Tweet> findAllByUserId(UUID uuid);
}
