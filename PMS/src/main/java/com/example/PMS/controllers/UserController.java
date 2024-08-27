package com.example.PMS.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PMS.entities.Users;
import com.example.PMS.repositories.UserRepository;
import com.example.PMS.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService uSrv;


    @Autowired
    UserRepository uRepo;




    @PostMapping("/add")
    public String addSlot(@RequestBody Users u){
        uRepo.save(u);
        return "user added successfully";
    }
    
    @PostMapping("/updateCheck")
    public String updateCheck(@RequestBody Map<String,Integer> requestBody)
    {
       
        int id=requestBody.get("id");
        uSrv.updateCheck(id);
        return "updated successfully";
    }

    @PostMapping("/cost")
    public int getCost(@RequestBody Map<String,Integer> requestBody)
    {
        int userId=requestBody.get("userId");
        System.out.println(userId);
        return uSrv.getCost(userId);
    }

    @PostMapping("/removeBooking")
    public String removeBooking(@RequestBody Map<String,Integer> requestBody)
    {
        int userId=requestBody.get("userId");

        uSrv.removeBooking(userId);
        return "Removed successfully";
    }
}
