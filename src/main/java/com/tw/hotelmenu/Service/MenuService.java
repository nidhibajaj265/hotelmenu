package com.tw.hotelmenu.Service;

import com.tw.hotelmenu.Model.MenuItem;
import com.tw.hotelmenu.Repository.MenuItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {

    @Autowired
    MenuItemRepository menuItemRepository;

    public List<MenuItem> getMenuItems()
    {
                return (List<MenuItem>) menuItemRepository.findAll();
    }
}
