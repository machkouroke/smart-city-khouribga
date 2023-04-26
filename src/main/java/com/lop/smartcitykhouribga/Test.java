package com.lop.smartcitykhouribga;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import com.lop.smartcitykhouribga.models.Repositories.JobOfferRepository;
import com.lop.smartcitykhouribga.models.Repositories.RelationRepository;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Test {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private RelationRepository relationRepository;

    @Transactional
    public void test() {

        User user = userRepository.findByMail("machkouroke@gmail.com").get();
        JobOffer offer = jobOfferRepository.findById(7L).get();

        UserOfferRelation relation = new UserOfferRelation(user, offer);
        relation.setId(new UserOfferRelationKeys(user.getId(), offer.getId(), "liked"));
        UserOfferRelation falseRelation = new UserOfferRelation(user, offer);
        falseRelation.setId(new UserOfferRelationKeys(user.getId(), offer.getId(), "postulated"));
        System.out.println("Doit retourner vrai");
        System.out.println(user.getRelatedOffers().contains(relation));
        System.out.println("Doit retourner faux");
        System.out.println(user.getRelatedOffers().contains(falseRelation));
    }
}
