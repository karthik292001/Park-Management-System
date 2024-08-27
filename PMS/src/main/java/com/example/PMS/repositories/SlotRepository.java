package com.example.PMS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PMS.entities.Slots;

public interface  SlotRepository extends JpaRepository<Slots, Integer>{

    List<Slots> findAllByAvailability(String string);
    
}
