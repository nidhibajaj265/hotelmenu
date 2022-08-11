package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.controller.controllerHelper.ControllerHelper;
import com.tw.hotelmenu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HomeController.class)
class HomeControllerTest extends ControllerHelper {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldShowWelcomeMessage() throws Exception {
        String expectedResponseContent = "Welcome to My Kitchen";
        String actualResponseContent = mockMvc.perform(get("/").contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(expectedResponseContent, actualResponseContent);

    }

}