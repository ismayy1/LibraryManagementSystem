package com.tpe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @NotBlank(message = "The book title cannot be Empty.")
    @NotNull(message = "The book title cannot be null. Please provide the name")
    private String title;

    @NotBlank(message = "The author name cannot be Empty.")
    @NotNull(message = "The author name cannot be null. Please provide the author")
    @Size(min = 2, max = 50, message = "Author name '${validatedValue}' must be between {min}-{max} characters")
    // '${}' -> external var,
    // '{}' -> internal var
    private String author;

    @NotBlank(message = "The published date cannot be Empty.")
    @NotNull(message = "The published date cannot be null. Please provide the publication date")
    private String publishDate;
}
