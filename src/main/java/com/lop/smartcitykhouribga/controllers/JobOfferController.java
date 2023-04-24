package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.DTO.OfferDTO;
import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserDetailsImpl;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import com.lop.smartcitykhouribga.models.Services.JobOfferService;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/offers")
public class JobOfferController {

    @Autowired
    private JobOfferService offerService;

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/add")
    public void addOffer(@AuthenticationPrincipal UserDetailsImpl details,
                         @ModelAttribute OfferDTO dto){

        User user = details.getUser(userRepository);
        dto.setPostedAt(new Date());

        JobOffer offer= offerService.save(offerService.convertToEntity(dto));

        userService.saveRelation(user, offer, "posted");
    }

    @PostMapping("/like")
    public void likeOffer(@AuthenticationPrincipal UserDetailsImpl details,
                          @RequestParam("id") Long id){
        User user = details.getUser(userRepository);
        JobOffer offer= offerService.findById(id);

        userService.saveRelation(user, offer, "liked");
    }

    @PostMapping("/postulate")
    public void postulateOffer(@AuthenticationPrincipal UserDetailsImpl details,
                          @RequestParam("id") Long id){
        User user = details.getUser(userRepository);
        JobOffer offer= offerService.findById(id);

        userService.saveRelation(user, offer, "postulated");
    }

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
