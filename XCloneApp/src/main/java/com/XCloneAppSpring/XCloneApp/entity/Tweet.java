package com.XCloneAppSpring.XCloneApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Tweet {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(length = 1000)
    private String content;

    @CreationTimestamp
    private Date created_time;

    @UpdateTimestamp
    private Date updated_time;

    private Integer liked_count;
}
