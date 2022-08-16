package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

   // @GetMapping("/")
   @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}
