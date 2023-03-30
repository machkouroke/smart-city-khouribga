package com.lop.smartcitykhouribga.models.Repositories;


import com.lop.smartcitykhouribga.models.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>,
        CrudRepository<User, Long> {
}
