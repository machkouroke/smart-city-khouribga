package com.lop.smartcitykhouribga;

import com.lop.smartcitykhouribga.models.Entities.Entreprise;
import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import com.lop.smartcitykhouribga.models.Services.JobOfferService;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

@SpringBootApplication
public class SmartCityKhouribgaApplication {


    public static void main(String[] args) {

        var context =         SpringApplication.run(SmartCityKhouribgaApplication.class, args);

        UserService userService= context.getBean(UserService.class);
        JobOfferService offerService= context.getBean(JobOfferService.class);

//        User user1= new User("OKE","Machkour","oke@gmail.com","qwertyu","recruteur","ewrg","qwddvcv");
//        User user2= new User("KOUHOSSOUNON","Morel","momo@gmail.com","qwertvbvbdv","user","avbc","xcvbbnn");
//
//
//        Entreprise e1=offerService.saveCompany(new Entreprise("DAO Sarl","Khouribga"));
//
//        JobOffer offer1= new JobOffer("Developpeur Web", "Developpeur Web informatique awsedrfgvbnbnb","Stage","informatique",new Date());
//        offer1.setEntreprise(e1);
//
//        user1=userService.save(user1);
//        user2=userService.save(user2);
//
//        offer1=offerService.save(offer1);
//
//        UserOfferRelation uor= new UserOfferRelation(user1, offer1);
//        uor.setId(new UserOfferRelationKeys(user1.getId(),offer1.getId(),"poste"));
//        uor=userService.saveRelation(uor);

//        Entreprise e2=offerService.saveCompany(new Entreprise("CIH","Maroc"));
//        User user3= userService.findById(1L);
//        User user4= userService.findById(2L);
//        JobOffer offer2= new JobOffer("Alternance Data Scientist","Data Scientist rtyghbnbn","Alternance","Informatique",new Date());
//        offer2.setEntreprise(e2);
//        offer2= offerService.save(offer2);
//        UserOfferRelation uor1= new UserOfferRelation(user3, offer2);
//        uor1.setId(new UserOfferRelationKeys(user3.getId(),offer2.getId(),"poste"));
//        UserOfferRelation uor2= new UserOfferRelation(user4, offer2);
//        uor2.setId(new UserOfferRelationKeys(user4.getId(),offer2.getId(),"like"));
//        userService.saveRelation(uor1); userService.saveRelation(uor2);
    }

}
