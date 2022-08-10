package com.tw.hotelmenu.Service;

import com.tw.hotelmenu.Model.User;
import com.tw.hotelmenu.Repository.UserRepository;
import com.tw.hotelmenu.Service.dto.UserDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp()
    {
        userService = new UserService(userRepository);
    }

    @Test
    void shouldLoadUserDetailsFromUsername(){

        User testUser = new User(1L,
                "email@example.com",
                "name",
                "password",
                "USER");

        UserDetails expectedUserDetails = UserDetailsDTO.create(testUser);

        when(userRepository.findByEmail("email@example.com")).thenReturn(Optional.of(testUser));

        UserDetails actualUserDetails = userService.loadUserByUsername("email@example.com");

        assertEquals(expectedUserDetails, actualUserDetails);

    }

    @Test
    void shouldThrowUserNotFoundException(){

        when(userRepository.findByEmail("email@example.com")).thenReturn(Optional.empty());

        UsernameNotFoundException actualException = assertThrows(UsernameNotFoundException.class,
                ()->userService.loadUserByUsername("email@example.com"));

        assertEquals("No User exists with Username : email@example.com", actualException.getMessage());
    }
}