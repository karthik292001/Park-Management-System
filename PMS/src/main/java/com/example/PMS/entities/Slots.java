package com.example.PMS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Slots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String mallName;
    public String slotNumber;
    public String availability="available";

    
}
