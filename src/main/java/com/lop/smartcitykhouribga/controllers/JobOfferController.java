package com.lop.smartcitykhouribga.controllers;

import com.lop.smartcitykhouribga.models.Entities.DTO.OfferDTO;
import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import com.lop.smartcitykhouribga.models.Services.JobOfferService;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addOffer(@AuthenticationPrincipal User details,
                         @ModelAttribute OfferDTO dto){

        User user = details;
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

        UserOfferRelation uor1= new UserOfferRelation(user, offer);
        uor1.setId(new UserOfferRelationKeys(user.getId(),offer.getId(),type));


        if(user.getRelatedOffers().stream().anyMatch(r->r.equals(uor))){
            userService.deleteRelation(uor);
            System.out.println("It contains");
        }else {
            userService.saveRelation(uor);
            System.out.println("No");
        }

    }

    @GetMapping
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
