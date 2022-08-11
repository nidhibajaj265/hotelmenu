package com.tw.hotelmenu.controller.controllerHelper;

import com.tw.hotelmenu.service.UserService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class ControllerHelper {
    @MockBean
    protected UserService userService;
    @MockBean
    protected BCryptPasswordEncoder bCryptPasswordEncoder;
}
