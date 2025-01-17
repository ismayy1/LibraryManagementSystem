package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_borrower")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Please enter a valid first name.")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Please enter a valid last name.")
    @Column(nullable = false)
    private String lastName;

    private String phoneNumber;

    @Email(message = "Please enter a valid email.")
    @Column(nullable = false, unique = true)
    private String email;

//    We are on the ONE side
    @OneToMany(mappedBy = "borrower")
    private List<Book> bookList = new ArrayList<>();

    private LocalDateTime registrationDate;

    @PrePersist
    public void prePersist() {
        this.registrationDate = LocalDateTime.now();
    }
}
