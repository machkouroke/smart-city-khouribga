package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserDetailsImpl;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> saveUser(@ModelAttribute User user,
                                           @RequestParam("cv")MultipartFile cv,
                                           @RequestParam("photo") MultipartFile photo) throws IOException {
        userService.register(user, cv, photo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/offers/{type}")
    public ResponseEntity<Set<JobOffer>> getRelatedOffers(@AuthenticationPrincipal UserDetailsImpl details,
                                          @PathVariable String type){
        User user= details.getUser(userRepository);
        return ResponseEntity.ok().body(userService.findOffersRelatedToUser(user.getId(), type));
    }



}
