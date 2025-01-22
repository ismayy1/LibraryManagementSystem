package com.tpe.service;

import com.tpe.domain.Role;
import com.tpe.domain.User;
import com.tpe.domain.enums.UserRole;
import com.tpe.dto.UserDTO;
import com.tpe.repository.MemberRepository;
import com.tpe.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

//    private MemberRepository memberRepository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public void saveUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setUserName(userDTO.getUserName());
//        newUser.setPassword(userDTO.getPassword());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        Role role = roleService.findRoleByType(UserRole.ROLE_ADMIN);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        newUser.setRoles(roles);

        userRepository.save(newUser);
    }
}
