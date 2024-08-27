package com.example.PMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PMS.entities.BookingSlot;
import com.example.PMS.entities.Slots;
import com.example.PMS.entities.Users;
import com.example.PMS.repositories.BookingRepository;
import com.example.PMS.repositories.SlotRepository;
import com.example.PMS.repositories.UserRepository;

@Service
public class BookingService {

    @Autowired
    BookingRepository bRepo;

    @Autowired
    SlotRepository sRepo;

    @Autowired
    UserRepository uRepo;

    public void addBooking(BookingSlot bs) {
       
        

        Users u=uRepo.findByName(bs.getUsername());
        bs.setUserId(u.getId());
        bs.setUser(u);
        bRepo.save(bs);
    }

    public void updateBooking(int bookingId, int slotId) {
        BookingSlot bs=bRepo.findById(bookingId).get();
        Slots s=sRepo.findById(slotId).get();
        s.setAvailability("notAvailable");
        sRepo.save(s);

        bs.setStatus("Booked");
        bs.setSlotId(slotId);
        bs.setSlot(s);
        bRepo.save(bs);
        
    }

    public BookingSlot getBooking(int userId) {
        return bRepo.findByUserId(userId);
    }


    public List<BookingSlot> getAllBooking() {
        return bRepo.findAll();
    }

    public List<BookingSlot> requestBooking() {
        return bRepo.findAllByStatus("notBooked");
    }
    
}
