package com.lop.smartcitykhouribga.models.Services;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Repositories.JobOfferRepository;
import com.lop.smartcitykhouribga.models.Repositories.RelationRepository;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RelationRepository relationRepository;

    @Autowired
    public UserService(UserRepository userRepository, JobOfferRepository jobOfferRepository, RelationRepository relationRepository) {
        this.userRepository = userRepository;
        this.relationRepository = relationRepository;
    }

    public User save(User toSave){
        User newUser= this.userRepository.save(toSave);
        return newUser;
    }

    public UserOfferRelation saveRelation(UserOfferRelation toSave){
        return this.relationRepository.save(toSave);
    }

    public void delete(Long id){
        User user= this.userRepository.findById(id).orElse(null);
        if(user == null){
            throw new IndexOutOfBoundsException();
        }
        this.userRepository.deleteById(id);
    }

    public User findById(Long id){
        User user= this.userRepository.findById(id).orElse(null);
        if(user == null){
            throw new IndexOutOfBoundsException();
        }
        return user;
    }

    public List<User> findAll(){
        return (List<User>) this.userRepository.findAll();
    }

    public Set<JobOffer> findOffersRelatedToUser(Long id, String type){
        User user= this.userRepository.findById(id).orElse(null);
        return user.getRelatedOffers()
                .stream()
                .filter(relatedOffer->
                        relatedOffer.getId()
                                .getType()
                                .equals(type))
                .map(
                        UserOfferRelation::getOffer
                )
                .collect(Collectors.toSet());
    }

}
