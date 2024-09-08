package com.XCloneAppSpring.XCloneApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated()")
public class TestController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello merhaba";
    }
}
