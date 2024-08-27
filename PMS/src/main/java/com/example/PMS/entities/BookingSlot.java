package com.example.PMS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class BookingSlot {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String username;
    private String vehicleNumber;
    private int slotId;
    private int userId;
    private String status="notBooked";


    @OneToOne
    @JoinColumn(name="slot")
    private Slots slot;

    @OneToOne
    @JoinColumn(name="user")
    private Users user;
    
}
