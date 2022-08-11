package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.controller.controllerHelper.ControllerHelper;
import com.tw.hotelmenu.model.MenuItem;
import com.tw.hotelmenu.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = MenuItemController.class)
class MenuItemControllerTest extends ControllerHelper {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MenuService menuService;

    @Test
    void shouldReturnListOfMenuItems() throws Exception{
        List<MenuItem> expectedMenuItems = Arrays.asList(MenuItem.builder().name("idli").price(10.75d)
                        .type("BREAKFAST").build(),
                         MenuItem.builder().name("vada").price(11.5d).type("LUNCH").build());

        when(menuService.getMenuItems()).thenReturn(expectedMenuItems);

        mockMvc.perform(get("/menu"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("idli"))
                .andExpect(jsonPath("$[1].name").value("vada"))
                .andExpect(jsonPath("$[0].price").value("10.75"))
                .andExpect(jsonPath("$[1].price").value("11.5"))
                .andExpect(jsonPath("$[0].type").value("BREAKFAST"))
                .andExpect(jsonPath("$[1].type").value("LUNCH"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

       verify(menuService, times(1)).getMenuItems();
    }

}