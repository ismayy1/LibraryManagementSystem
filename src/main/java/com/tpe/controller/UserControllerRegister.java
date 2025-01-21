package com.tpe.controller;

import com.tpe.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class UserControllerRegister {

    private MemberService memberService;

//    http://localhost:8081/
    @PostMapping
}
