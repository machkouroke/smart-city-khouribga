package com.lop.smartcitykhouribga.models.Repositories;

import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RelationRepository extends PagingAndSortingRepository<UserOfferRelation, UserOfferRelationKeys>,
        CrudRepository<UserOfferRelation, UserOfferRelationKeys> {
}
