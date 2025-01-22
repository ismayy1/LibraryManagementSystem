package com.tpe.repository;

import com.tpe.domain.User;
import com.tpe.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    //    Spring security methods
    Optional<User> findByUserName(String username) throws ResourceNotFoundException;
//     findByUserName -> userName should be same as the field in user class


}
