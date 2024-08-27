package com.example.PMS.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public String name;
    public String role;
    public LocalDateTime checkIn;
    public String checkInStatus;
    public LocalDateTime checkOut;
   
    
}
