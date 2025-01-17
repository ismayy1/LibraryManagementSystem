package com.tpe.repository;

import com.tpe.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // optional
public interface BookRepository extends JpaRepository<Book, Long> {

//    TASK 6-c
    List<Book> findByTitle(String bookTitle);   // Derivation
}
