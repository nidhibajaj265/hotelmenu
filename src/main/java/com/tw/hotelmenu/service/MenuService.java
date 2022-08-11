package com.tw.hotelmenu.service;

import com.tw.hotelmenu.model.MenuItem;
import com.tw.hotelmenu.repository.MenuItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getMenuItems()
    {
                return (List<MenuItem>) menuItemRepository.findAll();
    }
}
