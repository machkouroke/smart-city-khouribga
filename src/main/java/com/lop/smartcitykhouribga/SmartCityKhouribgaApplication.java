package com.lop.smartcitykhouribga;


import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import com.lop.smartcitykhouribga.models.Repositories.JobOfferRepository;
import com.lop.smartcitykhouribga.models.Repositories.RelationRepository;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.Set;

@SpringBootApplication
public class SmartCityKhouribgaApplication {





    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }




    public static void main(String[] args) throws IOException {


        var context = SpringApplication.run(SmartCityKhouribgaApplication.class, args);

    }

}
