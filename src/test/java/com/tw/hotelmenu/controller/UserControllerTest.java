package com.tw.hotelmenu.controller;

import com.tw.hotelmenu.controller.controllerHelper.ControllerHelper;
import com.tw.hotelmenu.model.User;
import com.tw.hotelmenu.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest extends ControllerHelper {

    @Autowired
    MockMvc mockMvc;

    private String email;
    private String name;
    private String password;

    @BeforeEach
    void setUp() {
        email = "email@example.com";
        name = "SampleName";
        password = "password@123";
    }

    @Test
    void shouldCreateNewUserWithTheProvidedDetails() throws Exception {
        User user = new User("SampleName","email@example.com","password@123");

        when(userService.save("SampleName","email@example.com","password@123"))
                .thenReturn(user);

            mockMvc.perform(post("/newUser")
                    .param("name", name)
                    .param("email", email)
                    .param("password", password)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

}