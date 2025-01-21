package com.tpe.service;

import com.tpe.domain.Member;
import com.tpe.dto.MemberDTO;
import com.tpe.exception.ConflictException;
import com.tpe.exception.MemberNotFoundException;
import com.tpe.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@AllArgsConstructor // it can be created instead of constructor injection
public class MemberService {

//    Constructor injection
    private MemberRepository memberRepository;

//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    Constructor injection

//    TASK 1-b:
    public void saveMember(MemberDTO memberDTO) {


        if (memberRepository.existsByEmail(memberDTO.getEmail())) {
            throw new ConflictException("The provided Email address is already in use.");
        }

        Member member = new Member();

//        member.setFirstName(memberDTO.getFirstName());
//        member.setLastName(memberDTO.getLastName());
//        member.setPhoneNumber(memberDTO.getPhoneNumber());
//        member.setEmail(memberDTO.getEmail());

//        We created a constructor in Member class, so all above operations will not be repeated in the future, if we need to do another mapping
        Member member1 = new Member(memberDTO);

        memberRepository.save(member);
    }

//    TASK 2-b:
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

//    TASK 3-b:
    public Member findMemberById(long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("No member found with the given ID: " + id));
    }
}
