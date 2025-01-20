package com.tpe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {


    @NotBlank(message = "Please enter a valid first name.")
    private String firstName;

    @NotBlank(message = "Please enter a valid last name.")
    private String lastName;

    private String phoneNumber;

    @Email(message = "Please enter a valid email.")
    private String email;

}
