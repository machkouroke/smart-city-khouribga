package com.lop.smartcitykhouribga.models.Entities.DTO;

import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserPOJO {

    private String mail;

    private String password;

    private User getUser(UserRepository userRepository){
        User user= userRepository.findByMail(getMail()).orElse(null);
        assert user!= null;
        return user;
    }
}
