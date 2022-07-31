package com.tw.hotelmenu.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    String base() {
        return "Welcome to My Kitchen";
    }

}
