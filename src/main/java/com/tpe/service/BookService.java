package com.tpe.service;

import com.tpe.domain.Book;
import com.tpe.exception.BookNotFoundException;
import com.tpe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired  // optional
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    TASK 1-b
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

//    TASK 2-b
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

//    TASK 3-b
    public Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("No book found with the given ID: " + id));
    }

//    TASK 4-b
    public void deleteBook(Long id) {
//        findBookById(id);
//        bookRepository.deleteById(id);
        Book foundBook = findBookById(id);
        bookRepository.delete(foundBook);
    }

//    TASK 6-b
    public List<Book> findBooksByTitle(String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    public Page<Book> findAllBooksWithPagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
