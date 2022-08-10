package com.tw.hotelmenu.Service.dto;

import com.tw.hotelmenu.Model.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserDetailsDTO implements UserDetails {

    public final String username;
    public final String password;
    private List<SimpleGrantedAuthority> authorities;


    public UserDetailsDTO(String emailId, String password, List<SimpleGrantedAuthority> authorities) {
        this.username = emailId;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetails create(User user) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new UserDetailsDTO(user.getEmail(), user.getPassword(), simpleGrantedAuthorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
