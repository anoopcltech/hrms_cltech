package com.cltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cltech.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
