package com.tw.hotelmenu.Controller;

import com.tw.hotelmenu.Model.MenuItem;
import com.tw.hotelmenu.Service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = MenuItemController.class)
class MenuItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MenuService menuService;

    @Test
    void shouldReturnListOfMenuItems() throws Exception{
        List<MenuItem> expectedMenuItems = Arrays.asList(MenuItem.builder().name("idli").build(),
                MenuItem.builder().name("vada").build());

        when(menuService.getMenuItems()).thenReturn(expectedMenuItems);

        mockMvc.perform(get("/menu"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("idli"))
                .andExpect(jsonPath("$[1].name").value("vada"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

       verify(menuService, times(1)).getMenuItems();
    }

}