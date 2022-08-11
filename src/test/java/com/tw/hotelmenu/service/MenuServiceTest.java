package com.tw.hotelmenu.service;

import com.tw.hotelmenu.model.MenuItem;
import com.tw.hotelmenu.repository.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class MenuServiceTest {

    @Mock
    private MenuItemRepository menuItemRepository;
    private MenuService menuService;

    @BeforeEach
    void Setup()
    {
        menuService = new MenuService(menuItemRepository);
    }

    @Test
    void shouldReturnEmptyListWhenThereAreNoItemsInMenu(){

        when(menuItemRepository.findAll()).thenReturn(Collections.emptyList());

        assertEquals(0, menuService.getMenuItems().size());

    }

    @Test
    void shouldReturnListofMenuItem(){
        List<MenuItem> expectedMenuItems = Arrays.asList(MenuItem.builder().name("idli").price(60.7)
                        .type("BREAKFAST").build(),
                MenuItem.builder().name("vada").price(45.8).type("LUNCH").build());

        when(menuItemRepository.findAll()).thenReturn(expectedMenuItems);

      List<MenuItem>  actualMenuItems = menuService.getMenuItems();

        assertEquals(2, menuService.getMenuItems().size());
        assertEquals(expectedMenuItems, actualMenuItems);
    }
}