package com.XCloneSpringBootApp.XCloneApp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("")
    public String getHello(){
        return "Hello";
    }
}
