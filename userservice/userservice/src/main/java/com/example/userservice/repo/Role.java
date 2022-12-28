package com.example.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Role extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
