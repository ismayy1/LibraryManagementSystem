package com.tpe.service;

import com.tpe.domain.Book;
import com.tpe.dto.BookDTO;
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

//    TASK 8-b
    public Book updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = findBookById(id);

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPublishDate(bookDTO.getPublishDate());

        return bookRepository.save(existingBook);  // works like saveOrUpdate
    }

//    TASK 9-b
    public List<Book> findBooksByAuthor(String authorName) {
        List<Book> foundBooks = bookRepository.findByAuthorWithJPQL(authorName);

        if (foundBooks.isEmpty()) {
            throw new BookNotFoundException("No books found with the given Author Name: " + authorName);
        }
        return foundBooks;
    }

//    HW:
    public List<Book> findBookByTitleAndAuthor(String title, String author) {
        List<Book> foundBook = bookRepository.findByTitleContainsAndAuthorContainsAllIgnoreCase(title, author);

        if (foundBook.isEmpty()) {
            throw new BookNotFoundException("No books found with the given Author Name: " + author +
                    ", or Title: " + title);
        }

        return foundBook;
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepository.findByTitleContainsIgnoreCase(title);
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findByAuthorContainsIgnoreCase(author);
    }
}
