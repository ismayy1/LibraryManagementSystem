package com.tpe.repository;

import com.tpe.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // optional
public interface BookRepository extends JpaRepository<Book, Long> {

//    TASK 6-c
    List<Book> findByTitle(String bookTitle);   // Derivation






//    TASK 9-c
//    String sqlQ = "SELECT * FROM t_book t WHERE t.author = ?";
    @Query("SELECT b FROM Book b WHERE b.author=:author")   // JPQL query
    List<Book> findByAuthorWithJPQL(@Param("author") String authorName);

//    HW:
    @Query("SELECT b FROM Book b WHERE b.title=:title AND b.author=:author")
    List<Book> findByAuthorAndTitleJPQL(@Param("title") String title, @Param("author") String author);

//    HW:
//    The name of the method is a keyword from SpringDataJPA
    List<Book> findByTitleContainsAndAuthorContainsAllIgnoreCase(String title, String authorName);

    List<Book> findByTitleContainsIgnoreCase(String title);

    List<Book> findByAuthorContainsIgnoreCase(String author);
}
