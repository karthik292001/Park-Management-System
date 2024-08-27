package com.example.PMS.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PMS.entities.BookingSlot;
import com.example.PMS.entities.Slots;
import com.example.PMS.entities.Users;
import com.example.PMS.repositories.BookingRepository;
import com.example.PMS.repositories.SlotRepository;
import com.example.PMS.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository uRepo;

    @Autowired
    SlotRepository sRepo;

    @Autowired
    BookingRepository bRepo;

    public void updateCheck(int id) {
        Users u=uRepo.findById(id).get();
        u.setCheckIn(LocalDateTime.now());
        u.setCheckInStatus("checkedIn");
        
        uRepo.save(u);
    }

    public void removeBooking(int userId) {
        Users u=uRepo.findById(userId).get();
        u.setCheckInStatus("checkedOut");
        u.setCheckOut(LocalDateTime.now());
        uRepo.save(u);

        BookingSlot bs=bRepo.findByUserId(userId);
        bRepo.deleteById(bs.getId());
        
        Slots s=sRepo.findById(bs.getSlotId()).get();
        s.setAvailability("available");
        sRepo.save(s);
    }

    public int getCost(int userId) {
        Users u=uRepo.findById(userId).get();
        int cost=20;
        int totalHour= u.getCheckOut().getHour()-u.getCheckIn().getHour();
        if(totalHour>0){
            cost=totalHour*20;
        }
        return cost;
    }
    
    
}
