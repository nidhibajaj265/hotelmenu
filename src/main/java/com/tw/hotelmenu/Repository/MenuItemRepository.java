package com.tw.hotelmenu.Repository;

import com.tw.hotelmenu.Model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
