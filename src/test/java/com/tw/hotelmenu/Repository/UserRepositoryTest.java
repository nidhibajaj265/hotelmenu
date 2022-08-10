package com.tw.hotelmenu.Repository;

import com.tw.hotelmenu.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
//@Transactional
@AutoConfigureTestDatabase(replace = NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void shouldReturnUserWithSavedEmail()
    {
        User expectedUser = new User(1L,
                "email@example.com",
                "name",
                "password","USER");


        userRepository.save(expectedUser);
        Optional<User> actualUserOptional = userRepository.findByEmail("email@example.com");

        assertTrue(actualUserOptional.isPresent());

        User actualUser = actualUserOptional.get();

        assertEquals("email@example.com", actualUser.getEmail());
        assertEquals("name", actualUser.getName());
        assertEquals("password", actualUser.getPassword());


    }

    @Test
    void shouldReturnEmptyOptionalUserWhenGivenEmailIsNotSaved(){

        User user = User.builder().name("name").email("email@example.com").id(1L).password("password").build();

        userRepository.save(user);

        Optional<User> actualUserOptional = userRepository.findByEmail("different-email@example.com");

        assertFalse(actualUserOptional.isPresent());

    }

}
