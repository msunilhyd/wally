package com.sunil.validation.repository;

import com.sunil.validation.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUserId(int id);
}
