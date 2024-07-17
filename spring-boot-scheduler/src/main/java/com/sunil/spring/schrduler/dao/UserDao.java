package com.sunil.spring.schrduler.dao;

import com.sunil.spring.schrduler.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users, Integer> {
}
