package com.tpe.controller;

import com.tpe.domain.Book;
import com.tpe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // the difference between @Controller, the @RestController has a Response body init
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

//    TASK 1-a: Save a Book
//    http://localhost:8080/book + POST + JSON body
    @PostMapping
    public ResponseEntity<Map<String, String>> createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Book '" + book.getTitle() + "' created successfully.");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
//        return ResponseEntity.created(URI.create("/book/" + book.getId())).body(map); // same
    }

//    TASK 2-a: Get all Books
//    http://localhost:8080/book + GET + JSON body
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

//    TASK 3-a: Get a Book by its ID
//    http://localhost:8080/book/2 + GET + JSON body
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book foundBook = bookService.findBookById(id);
        return ResponseEntity.ok(foundBook);
    }

//    TASK 4-a Delete a Book by its ID
//    http://localhost:8080/book/2 + DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Book ID: " + id + " deleted successfully.");

        return ResponseEntity.ok(map);
    }

//    TASK 5-a: GET a book by its ID, however with query paremeter
//    http://localhost:8080/book/q?id=2 + GET
    @GetMapping("/q")
    public ResponseEntity<Book> getBookByIdWithQueryParam(@RequestParam("id") Long id) {
        Book foundBook = bookService.findBookById(id);
        return ResponseEntity.ok(foundBook);
    }

//    TASK 6-a: GET a book by its title using a request param
//    http://localhost:8080/book/search?title=Atomic Habits + GET
    @GetMapping("/search")
    public ResponseEntity<List<Book>> getBooksByTitle(@RequestParam(value = "title") String bookTitle) {
        List<Book> matchingBooks = bookService.findBooksByTitle(bookTitle);
        return ResponseEntity.ok(matchingBooks);
    }

//    TASK 7-a: GET Books in pages
//    http://localhost:8080/book?s?page=1&size=2&sort=publishDate&direction=ASC + GET
    @GetMapping("/s")
    public ResponseEntity<Page<Book>> getAllBooksWithPagination(@RequestParam("page") int page,
                                                                @RequestParam("size")int size,
                                                                @RequestParam("sort") String prop,
                                                                @RequestParam("direction") Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page-1, size, Sort.by(direction, prop));
        Page<Book> bookPage = bookService.findAllBooksWithPagination(pageable);
        return ResponseEntity.ok(bookPage);
    }
}
