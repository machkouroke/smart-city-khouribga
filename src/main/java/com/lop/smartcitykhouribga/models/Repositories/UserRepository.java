package com.lop.smartcitykhouribga.models.Repositories;


import com.lop.smartcitykhouribga.models.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>,
        CrudRepository<User, Long> {
    Optional<User> findByMail(String username);

}
