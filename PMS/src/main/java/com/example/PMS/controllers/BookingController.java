package com.example.PMS.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PMS.entities.BookingSlot;
import com.example.PMS.services.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bSrv;

    @PostMapping("/add")
    public String addBooking(@RequestBody BookingSlot bs)
    {
        System.out.println(bs);
        bSrv.addBooking(bs);
        return "Booking Added successfully";
    }
    
    @PostMapping("/update")
    public String addBooking(@RequestBody Map<String,Integer> requestBody)
    {

        int slotId=requestBody.get("slotId");
        int bookingId=requestBody.get("bookingId");
        bSrv.updateBooking(bookingId,slotId);
        return "Booking updated successfully";
    }


    @PostMapping("/getBooking/{userId}")
    public BookingSlot getBooking(@PathVariable int userId)
    {
        return bSrv.getBooking(userId);
    }

    

    @GetMapping("/getAllBooking")
    public List<BookingSlot> getAllBooking()
    {
        return bSrv.getAllBooking();
    }

    @GetMapping("/requestBooking")
    public List<BookingSlot> requestBooking()
    {
        return bSrv.requestBooking();
    }
    

}
