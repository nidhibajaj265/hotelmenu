package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    String base() {
        return "Welcome to My Kitchen";
    }

}
