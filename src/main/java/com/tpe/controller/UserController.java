package com.tpe.controller;

import com.tpe.dto.UserDTO;
import com.tpe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class UserController {

//    All RequestMapping starts with ("/register")
//    http://localhost:8080/register + POST + JSON Body

    private UserService userService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Register successfully.");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
