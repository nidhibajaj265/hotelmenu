package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.model.User;
import com.tw.hotelmenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newUser")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        return userService.save(name,email,password);
    }

}
