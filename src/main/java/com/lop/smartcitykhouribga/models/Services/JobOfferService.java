package com.lop.smartcitykhouribga.models.Services;

import com.lop.smartcitykhouribga.models.Entities.DTO.OfferDTO;
import com.lop.smartcitykhouribga.models.Entities.Entreprise;
import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Repositories.CompanyRepository;
import com.lop.smartcitykhouribga.models.Repositories.JobOfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobOfferService {

    private JobOfferRepository jobOfferRepository;

    private CompanyRepository companyRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public JobOfferService(JobOfferRepository jobOfferRepository, CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    public JobOffer save(JobOffer toSave){
        return this.jobOfferRepository.save(toSave);
    }

    public Entreprise saveCompany(Entreprise e){
        return this.companyRepository.save(e);
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

    public JobOffer convertToEntity(OfferDTO offerDTO){
        Entreprise e= companyRepository.findByName(offerDTO.getEnterpriseName());

        JobOffer offer= modelMapper.map(offerDTO, JobOffer.class);
        offer.setEntreprise(e);

        return offer;
    }

    public OfferDTO convertToDTO(JobOffer offer){
        OfferDTO dto= modelMapper.map(offer, OfferDTO.class);
        dto.setEnterpriseName(offer.getEntreprise().getName());

        return dto;
    }
}
