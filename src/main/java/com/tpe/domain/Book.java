package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_book")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "The book title cannot be Empty.")
    @NotNull(message = "The book title cannot be null. Please provide the name")
    private String title;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "The author name cannot be Empty.")
    @NotNull(message = "The author name cannot be null. Please provide the author")
    @Size(min = 2, max = 50, message = "Author name '${validatedValue}' must be between {min}-{max} characters")
    // '${}' -> external var,
    // '{}' -> internal var
    private String author;

    @Column(nullable = false)
    @NotBlank(message = "The published date cannot be Empty.")
    @NotNull(message = "The published date cannot be null. Please provide the publication date")
    private String publishDate;
}
