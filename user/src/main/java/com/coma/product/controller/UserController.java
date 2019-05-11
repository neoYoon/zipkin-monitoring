package com.coma.product.controller;

import brave.Tracer;
import com.coma.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;


    @GetMapping("/get/{user}")
    public String getUser(@PathVariable("user") String user ) throws InterruptedException {
        return userService.getUser(user);
    }
}
