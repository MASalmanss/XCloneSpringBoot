package com.XCloneAppSpring.XCloneApp.repository;

import com.XCloneAppSpring.XCloneApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users , UUID> {
}
