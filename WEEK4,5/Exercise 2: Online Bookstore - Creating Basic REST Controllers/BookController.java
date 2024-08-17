package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Constructor to add some initial books
    public BookController() {
        books.add(new Book(1L, "Effective Java", "Siddharth", "9680134689991", 45.00));
        books.add(new Book(2L, "Spring in Action", "Seema", "9081617298945", 40.00));
    }

    // GET all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // GET a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = books.stream().filter(b -> b.getId().equals(id)).findFirst();
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
        books.add(newBook);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    // PUT to update a book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getId().equals(id)).findFirst();

        if (bookOpt.isPresent()) {
            Book existingBook = bookOpt.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setIsbn(updatedBook.getIsbn());
            return new ResponseEntity<>(existingBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getId().equals(id)).findFirst();
        if (bookOpt.isPresent()) {
            books.remove(bookOpt.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
