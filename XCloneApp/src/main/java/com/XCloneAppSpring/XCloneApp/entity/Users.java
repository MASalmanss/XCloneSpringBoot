package com.XCloneAppSpring.XCloneApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;

    private String fullname;

    private String description;

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets;


    @CreationTimestamp
    private Date created_time;

    @UpdateTimestamp
    private Date updated_time;

    private boolean is_active;

    @ManyToMany
    @JoinTable(name = "user_follwers" , joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private List<Users> followers;

    @ManyToMany(mappedBy = "followers")
    private List<Users> following;
}
