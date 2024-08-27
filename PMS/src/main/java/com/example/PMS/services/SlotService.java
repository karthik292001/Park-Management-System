package com.example.PMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PMS.entities.Slots;
import com.example.PMS.repositories.SlotRepository;

@Service
public class SlotService {

    @Autowired
    SlotRepository sRepo;

    public List<Slots> getAvailable() {
        return sRepo.findAllByAvailability("available");
    }


    
}
