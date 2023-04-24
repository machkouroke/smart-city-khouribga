package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> saveUser(@ModelAttribute User user,
                                           @RequestParam("cv")MultipartFile cv,
                                           @RequestParam("photo") MultipartFile photo) throws IOException {
        userService.uploadUserCV(user, cv);
        userService.uploadUserPhoto(user, photo);
        user.setRole("recruiter");

        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/{id}/offers/{type}")
    public Set<JobOffer> getRelatedOffers(@PathVariable Long id, @PathVariable String type){
        return userService.findOffersRelatedToUser(id, type);
    }



}
