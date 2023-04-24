package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Services.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/offers")
public class JobOfferController {

    @Autowired
    private JobOfferService offerService;

    @GetMapping("/")
    public List<JobOffer> getAllOffers(){
        return offerService.findAll();
    }

    @GetMapping("/{id}")
    public JobOffer getOffer(@PathVariable Long id){
        return offerService.findById(id);
    }

    @GetMapping("/{id}/users/{type}")
    public Set<User> getRelatedOffers(@PathVariable Long id, @PathVariable String type){
        return offerService.findUsersRelatedToOffer(id, type);
    }

    @GetMapping("/search/{word}")
    public List<JobOffer> search(@PathVariable String word){
        return offerService.searchOffers(word);
    }

    @DeleteMapping("/{id}")
    public void deleteOffers(@PathVariable Long id){
        offerService.deletebyId(id);
    }
}
