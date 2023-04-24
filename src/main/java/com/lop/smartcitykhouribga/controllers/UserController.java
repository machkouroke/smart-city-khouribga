package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> registerUser(@ModelAttribute User user,
                                               @RequestPart("photo") MultipartFile photo,
                                               @RequestPart("cv") MultipartFile cv) throws IOException {
        userService.uploadUserPhoto(user, photo);
        userService.uploadUserCV(user, cv);
        user.setRole("recruitor");
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
