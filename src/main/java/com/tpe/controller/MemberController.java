package com.tpe.controller;

import com.tpe.domain.Member;
import com.tpe.dto.MemberDTO;
import com.tpe.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //    TASK 1-a: Save a Member
//    http://localhost:8080/member + POST + JSON Body
    @PostMapping
    public ResponseEntity<Map<String, String>> createMember(@Valid @RequestBody MemberDTO memberDTO) {
        memberService.saveMember(memberDTO);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Member '" + memberDTO.getFirstName() + " " + memberDTO.getLastName() + "' created successfully.");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

//    TASK 2-a: Find all members
//    http://localhost:8080/member + GET
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAllMembers();
        return ResponseEntity.ok(members);
    }

//    TASK 3-a: Find Members by ID
//    http://localhost:8080/member/2 + GET
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") long id) {
        Member member = memberService.findMemberById(id);
        return ResponseEntity.ok(member);
    }

//    HW: Delete and update members.
}
