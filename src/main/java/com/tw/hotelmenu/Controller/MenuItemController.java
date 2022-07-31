package com.tw.hotelmenu.Controller;

import com.tw.hotelmenu.Model.MenuItem;
import com.tw.hotelmenu.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
