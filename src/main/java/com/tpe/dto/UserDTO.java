package com.tpe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Please provide firstName")
    private String firstName;

    @NotBlank(message = "Please provide lastName")
    private String lastName;

    @NotBlank(message = "Please provide userName")
    @Size(min = 4, max = 32, message = "The username must be between {min}-{max} characters.")
    private String userName;

    @NotBlank(message = "Please provide Password")
    private String password;
}
