package com.tpe.repository;

import com.tpe.domain.Member;
import com.tpe.domain.User;
import com.tpe.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.Optional;

@Repository //optional
public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByEmail(String email);

}
