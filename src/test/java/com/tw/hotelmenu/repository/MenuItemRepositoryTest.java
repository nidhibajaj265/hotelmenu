package com.tw.hotelmenu.repository;

import com.tw.hotelmenu.model.MenuItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@AutoConfigureTestDatabase(replace = NONE)
@DataJpaTest
class MenuItemRepositoryTest {

    @Autowired
    MenuItemRepository menuItemRepository;

    @Test
    void shouldReturnSavedMenuItemWithGivenName()
    {
        MenuItem expectedItem = new MenuItem(1L, "item", 22.5D, "Breakfast" );

        menuItemRepository.save(expectedItem);
        Optional<MenuItem> actualMenuItemOptional = menuItemRepository.findByName("item");

        assertTrue(actualMenuItemOptional.isPresent());
        MenuItem actualMenuItem = actualMenuItemOptional.get();

        assertEquals("item", actualMenuItem.getName());
        assertEquals(22.5, actualMenuItem.getPrice());
        assertEquals("Breakfast", actualMenuItem.getType());
    }

    @Test
    void shouldNotReturnMenuItemWhenGivenNameIsNotSaved()
    {
        MenuItem item = new MenuItem(1L, "item", 22.5D, "Breakfast" );

        menuItemRepository.save(item);
        Optional<MenuItem> menuItemOptional = menuItemRepository.findByName("different-item");

        assertFalse(menuItemOptional.isPresent());
    }
}