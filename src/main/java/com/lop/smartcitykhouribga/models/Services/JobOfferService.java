package com.lop.smartcitykhouribga.models.Services;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Repositories.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobOfferService {

    private JobOfferRepository jobOfferRepository;

    @Autowired
    public JobOfferService(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    public JobOffer saveOffer(JobOffer toSave){
        JobOffer newOffer= this.jobOfferRepository.save(toSave);
        return newOffer;
    }

    public void deletebyId(Long id){
        JobOffer offer= this.jobOfferRepository.findById(id).orElse(null);
        if(offer == null){
            throw new IndexOutOfBoundsException();
        }
        this.jobOfferRepository.deleteById(id);
    }

    public JobOffer findById(Long id){
        JobOffer offer= this.jobOfferRepository.findById(id).orElse(null);
        if(offer == null){
            throw new IndexOutOfBoundsException();
        }
        return offer;
    }

    public List<JobOffer> findAll(){
        return (List<JobOffer>) this.jobOfferRepository.findAll();
    }


    public List<JobOffer> searchOffers(String word){
        return jobOfferRepository.findByDescriptionContainingOrTitleContaining(word, word);
    }

    public Set<User> findUsersRelatedToOffer(Long id, String type){
        JobOffer offer= this.jobOfferRepository.findById(id).orElse(null);
        return offer.getRelatedUsers()
                .stream()
                .filter(relateduser->
                        relateduser.getId()
                                .getType()
                                .equals(type)
                )
                .map(UserOfferRelation::getUser)
                .collect(Collectors.toSet());
    }
}
