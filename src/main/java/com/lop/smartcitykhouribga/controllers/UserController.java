package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/{id}/offers/{type}")
    public Set<JobOffer> getRelatedOffers(@PathVariable Long id, @PathVariable String type){
        return userService.findOffersRelatedToUser(id, type);
    }



}
