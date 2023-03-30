package com.lop.smartcitykhouribga.models.Repositories;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobOfferRepository extends PagingAndSortingRepository<JobOffer, Long>,
        CrudRepository<JobOffer, Long> {
}
