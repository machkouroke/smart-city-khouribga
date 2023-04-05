package com.lop.smartcitykhouribga.models.Repositories;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOfferRepository extends PagingAndSortingRepository<JobOffer, Long>,
        CrudRepository<JobOffer, Long>{

    List<JobOffer> findByDescriptionContainingOrTitleContaining(@NonNull String description, @NonNull String title);

}
