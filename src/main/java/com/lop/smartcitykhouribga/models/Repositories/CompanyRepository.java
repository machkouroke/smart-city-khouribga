package com.lop.smartcitykhouribga.models.Repositories;

import com.lop.smartcitykhouribga.models.Entities.Entreprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompanyRepository extends PagingAndSortingRepository<Entreprise, Long>,
        CrudRepository<Entreprise, Long> {

    Entreprise findByName(String name);
}
