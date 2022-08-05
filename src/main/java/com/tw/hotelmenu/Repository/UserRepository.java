package com.tw.hotelmenu.Repository;

import com.tw.hotelmenu.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
