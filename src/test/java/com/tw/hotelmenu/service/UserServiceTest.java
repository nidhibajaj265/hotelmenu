package com.tw.hotelmenu.service;

import com.tw.hotelmenu.model.User;
import com.tw.hotelmenu.repository.UserRepository;
import com.tw.hotelmenu.service.dto.UserDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    @BeforeEach
    void setUp()
    {
        userService = new UserService(userRepository, bCryptPasswordEncoder);
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

    @Test
    void shouldSaveNewUser()
    {
        User userToBeCreated = new User("name",
                "email@example.com",
                "encoded-password");

        User expectedUser = new User("name",
                "email@example.com",
                "encoded-password");

        when(userRepository.save(userToBeCreated)).thenReturn(expectedUser);
        when(bCryptPasswordEncoder.encode("password")).thenReturn("encoded-password");

        User actualUser = userService.save("name", "email@example.com", "password");

        assertEquals(expectedUser,actualUser);
        verify(userRepository, times(1)).save(userToBeCreated);
    }
}