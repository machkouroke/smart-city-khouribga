package com.lop.smartcitykhouribga.models.Repositories;

import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RelationRepository extends PagingAndSortingRepository<UserOfferRelation, Long>,
        CrudRepository<UserOfferRelation, Long> {
}
