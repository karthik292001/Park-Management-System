package com.example.PMS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PMS.entities.Slots;
import com.example.PMS.repositories.SlotRepository;
import com.example.PMS.services.SlotService;

@RestController
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    SlotService sSrv;

    @Autowired
    SlotRepository sRepo;


    @PostMapping("/add")
    public String addSlot(@RequestBody Slots s){
        sRepo.save(s);
        return "Slot added successfully";
    }

    


    @GetMapping("/available")
    public List<Slots> updateCheck()
    {
        
        return sSrv.getAvailable();
    }
}
    

