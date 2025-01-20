package com.tpe.repository;

import com.tpe.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;

@Repository //optional
public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByEmail(String email);
}
