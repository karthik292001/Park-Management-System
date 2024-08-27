package com.example.PMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PMS.entities.Users;

public interface  UserRepository extends JpaRepository<Users, Integer>{

    Users findByName(String username);
    
}
