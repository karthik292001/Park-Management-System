package com.example.PMS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PMS.entities.BookingSlot;

public interface  BookingRepository extends JpaRepository<BookingSlot, Integer>{

    BookingSlot findByUserId(int userId);

    void deleteByUserId(int userId);

    List<BookingSlot> findAllByStatus(String keyword);
    
}
