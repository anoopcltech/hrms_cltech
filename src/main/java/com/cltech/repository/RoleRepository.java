package com.cltech.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cltech.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
