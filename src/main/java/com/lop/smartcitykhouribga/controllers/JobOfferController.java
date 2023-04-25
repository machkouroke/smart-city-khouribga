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
import org.springframework.http.HttpStatus;
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


        UserOfferRelation uor= new UserOfferRelation(user, offer);
        uor.setId(new UserOfferRelationKeys(user.getId(),offer.getId(),"posted"));
        userService.saveRelation(uor);
    }


    @PostMapping("/reaction")
    public void toggleReaction(@AuthenticationPrincipal UserDetailsImpl details,
                          @RequestParam("id") Long id, @RequestParam("type") String type){
        User user = details.getUser(userRepository);
        JobOffer offer= offerService.findById(id);

        UserOfferRelation uor= new UserOfferRelation(user, offer);
        uor.setId(new UserOfferRelationKeys(user.getId(),offer.getId(),type));

        if(user.getRelatedOffers().stream().anyMatch(r->r.equals(uor))){
            userService.deleteRelation(uor);
            System.out.println("It contains");
        }else {
            userService.saveRelation(uor);
            System.out.println("No");
        }

    }

    @PostMapping(value = "/delete/relation")
    public ResponseEntity<Long> deleteRelations(@AuthenticationPrincipal UserDetailsImpl details,
                                                @RequestParam("id") Long id, @RequestParam("type") String type){

        User user = details.getUser(userRepository);
        JobOffer offer= offerService.findById(id);

        UserOfferRelation uor= new UserOfferRelation(user, offer);
        uor.setId(new UserOfferRelationKeys(user.getId(),offer.getId(),type));

        System.out.println("id "+uor.getId().getType());
        userService.deleteRelation(uor);
        return new ResponseEntity<>(id, HttpStatus.OK);
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

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Long> deleteOffers(@RequestParam("id") Long id){
        System.out.println("id"+id);
        offerService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
