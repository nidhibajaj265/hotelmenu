package com.tw.hotelmenu.Service;

import com.tw.hotelmenu.Model.User;
import com.tw.hotelmenu.Repository.UserRepository;
import com.tw.hotelmenu.Service.dto.UserDetailsDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(UserDetailsDTO::create)
                .orElseThrow(()->new UsernameNotFoundException(String.format("No User exists with Username : %s", username)));
    }

    public User save(String name, String email, String password){
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        User user = new User("name","email@example.com", encodedPassword);
        return userRepository.save(user);
    }
}
