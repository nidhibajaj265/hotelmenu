package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.model.MenuItem;
import com.tw.hotelmenu.service.MenuService;
import com.tw.hotelmenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<MenuItem> getAllMenuItems(){

        return menuService.getMenuItems();
    }
}
