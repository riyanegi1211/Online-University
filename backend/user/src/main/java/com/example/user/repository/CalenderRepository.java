package com.example.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.model.CalenderItem;

public interface CalenderRepository extends JpaRepository<CalenderItem, Long>{
    List<CalenderItem> findAllByUserId(Long user_Id);
}
