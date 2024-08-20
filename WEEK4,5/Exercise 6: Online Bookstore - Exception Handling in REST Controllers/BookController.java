package com.example.bookstore.controller;

import com.example.bookstore.exception.BookNotFoundException;
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

    public BookController() {
        // Adding some sample books to the list
        books.add(new Book(1L, "Effective Java", "Siddharth", "96801346809991", 45.00));
        books.add(new Book(2L, "Spring in Action", "Seema", "9081617298945", 40.00));
    }

    // GET: Retrieve a book by ID with custom headers
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookByIdWithHeaders(@PathVariable Long id) {
        Book book = books.stream()
                         .filter(b -> b.getId().equals(id))
                         .findFirst()
                         .orElseThrow(() -> new BookNotFoundException(id));
        return ResponseEntity.ok()
                             .header("Custom-Header", "BookRetrieved")
                             .body(book);
    }

    // POST: Create a new book with custom headers
    @PostMapping
    public ResponseEntity<Book> createBookWithHeaders(@RequestBody Book newBook) {
        books.add(newBook);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .header("Custom-Header", "BookCreated")
                             .body(newBook);
    }

    // PUT: Update an existing book with custom headers
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookWithHeaders(@PathVariable Long id, @RequestBody Book updatedBook) {
        return books.stream()
                    .filter(b -> b.getId().equals(id))
                    .findFirst()
                    .map(book -> {
                        book.setTitle(updatedBook.getTitle());
                        book.setAuthor(updatedBook.getAuthor());
                        book.setPrice(updatedBook.getPrice());
                        book.setIsbn(updatedBook.getIsbn());
                        return ResponseEntity.ok()
                                             .header("Custom-Header", "BookUpdated")
                                             .body(book);
                    })
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                   .header("Custom-Header", "BookNotFound")
                                                   .build());
    }

    // DELETE: Delete a book by ID with custom headers
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookWithHeaders(@PathVariable Long id) {
        Book book = books.stream()
                         .filter(b -> b.getId().equals(id))
                         .findFirst()
                         .orElseThrow(() -> new BookNotFoundException(id));
        books.remove(book);
        return ResponseEntity.noContent()
                             .header("Custom-Header", "BookDeleted")
                             .build();
    }
}
