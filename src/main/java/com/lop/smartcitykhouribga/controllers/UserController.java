package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import com.lop.smartcitykhouribga.models.Services.JobOfferService;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JobOfferService jobOfferService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> saveUser(@ModelAttribute User user,
                                           @RequestParam("cv")MultipartFile cv,
                                           @RequestParam("photo") MultipartFile photo) throws IOException {
        userService.register(user, cv, photo);
        return ResponseEntity.ok(Map.of("opertaion", "registered"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/offers/{type}")
    public ResponseEntity<Map<String, Object>> getRelatedOffers(@AuthenticationPrincipal User user,
                                                                  @PathVariable String type){
        return ResponseEntity.ok(Map.of("success", true,
                "data", jobOfferService.convertToDTOList(userService.findOffersRelatedToUser(user.getId(), type)
                        .stream()
                        .collect(Collectors.toList()))));
    }
}
