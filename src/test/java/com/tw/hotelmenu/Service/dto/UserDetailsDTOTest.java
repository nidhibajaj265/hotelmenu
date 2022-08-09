package com.tw.hotelmenu.Service.dto;

import com.tw.hotelmenu.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailsDTOTest {

    @Test
    void shouldCreateUserDTOfromUser(){

        User user = User.builder().name("john doe").emailId("john@abc.com").password("abcd").role("USER").build();

        UserDetails userDetails = UserDetailsDTO.create(user);

        List<SimpleGrantedAuthority> simpleGrantedAuthority = Arrays.asList(new SimpleGrantedAuthority("USER"));

        assertEquals("john@abc.com", userDetails.getUsername());
        assertEquals("abcd", userDetails.getPassword());
        assertEquals(simpleGrantedAuthority, userDetails.getAuthorities());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isEnabled());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());


    }

}