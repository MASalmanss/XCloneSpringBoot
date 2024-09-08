package com.XCloneAppSpring.XCloneApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Users implements UserDetails {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;

    private String fullname;

    private String description;

    private String email;

    @Column(nullable = false)
    private String password;

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











    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
