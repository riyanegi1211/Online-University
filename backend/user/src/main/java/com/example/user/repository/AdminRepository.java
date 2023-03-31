package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
