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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

    @Transactional
    public String toggle(Set<UserOfferRelation> data, UserOfferRelation relation) {

        if (data.contains(relation)) {
            userService.deleteRelation(relation);
            return "deleted";
        } else {
            userService.saveRelation(relation);
            return "added";
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addOffer(@AuthenticationPrincipal User details,
                         @ModelAttribute OfferDTO dto) {

        User user = userService.findById(details.getId());
        dto.setPostedAt(new Date());

        JobOffer offer = offerService.save(offerService.convertToEntity(dto));


        UserOfferRelation uor = new UserOfferRelation(user, offer);
        uor.setId(new UserOfferRelationKeys(user.getId(), offer.getId(), "posted"));
        userService.saveRelation(uor);
        return ResponseEntity.ok(Map.of("success", true, "operation", "offer added"));
    }


    @PostMapping("/reaction")
    public ResponseEntity<Map<String, String>> toggleReaction(@AuthenticationPrincipal User details,
                                                              @RequestBody Map<String, String> data) {
        User user = userService.findById(details.getId());
        JobOffer offer = offerService.findById(Long.valueOf(data.get("job_id")));

        UserOfferRelation relation = new UserOfferRelation(user, offer);
        relation.setId(new UserOfferRelationKeys(user.getId(), offer.getId(), data.get("relation_type")));

        String operation = toggle(user.getRelatedOffers(), relation);
        return ResponseEntity.ok(Map.of("operation", operation));

    }

    @PostMapping(value = "/delete/relation")
    public ResponseEntity<Map<String, String>>  deleteRelations(@AuthenticationPrincipal User details,
                                                @RequestBody Map<String, String> data) {

        User user = userService.findById(details.getId());
        JobOffer offer = offerService.findById(Long.valueOf(data.get("job_id")));


        UserOfferRelation uor = new UserOfferRelation(user, offer);
        uor.setId(new UserOfferRelationKeys(user.getId(), offer.getId(), data.get("relation_type")));

        System.out.println("id " + uor.getId().getType());
        userService.deleteRelation(uor);
        return ResponseEntity.ok(Map.of("operation", "deleted"));
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllOffers() {
        return ResponseEntity.ok(Map.of("success", true, "data", offerService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOffer(@PathVariable Long id) {
        return ResponseEntity.ok(Map.of("success", true,
                "data", offerService.convertToDTO(offerService.findById(id))));
    }

    @GetMapping("/{id}/users/{type}")
    public ResponseEntity<Map<String, Object>> getRelatedOffers(@PathVariable Long id, @PathVariable String type) {
        return ResponseEntity.ok(Map.of("success", true,
                "data", offerService.findUsersRelatedToOffer(id, type)));
    }

    @GetMapping("/search/{word}")
    public ResponseEntity<List<JobOffer>> search(@PathVariable String word) {
        return new ResponseEntity<>(offerService.searchOffers(word), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteOffers(@RequestParam("id") Long id) {
        System.out.println("id" + id);
        offerService.deleteById(id);
        return new ResponseEntity<>("Offer deleted", HttpStatus.OK);
    }
}
