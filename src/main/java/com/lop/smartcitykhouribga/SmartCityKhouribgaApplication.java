package com.lop.smartcitykhouribga;

import com.lop.smartcitykhouribga.models.Entities.Entreprise;
import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SmartCityKhouribgaApplication {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SmartCityKhouribgaApplication.class, args);

        User user1= new User("OKE","Machkour","oke@gmail.com","qwertyu","recruteur","ewrg","qwddvcv");
        User user2= new User("KOUHOSSOUNON","Morel","momo@gmail.com","qwertvbvbdv","user","avbc","xcvbbnn");

        Entreprise e1= new Entreprise("DAO Sarl","Khouribga");

        JobOffer offer1= new JobOffer("Developpeur Web", "Developpeur Web informatique awsedrfgvbnbnb","Stage","informatique",new Date());
        offer1.setEntreprise(e1);


//        UserOfferRelation uor= new UserOfferRelation(ne)

    }

}
