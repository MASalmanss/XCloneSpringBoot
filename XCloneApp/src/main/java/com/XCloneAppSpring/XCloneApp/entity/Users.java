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

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets;


    @CreationTimestamp
    private Date created_time;

    @UpdateTimestamp
    private Date updated_time;
}
