package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Books", description = "Endpoints for managing books in the bookstore")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books", description = "Retrieve all books available in the bookstore")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of books", 
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class))}),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID", description = "Retrieve a specific book by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the book",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class))}),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<BookDTO> getBookById(
        @Parameter(description = "ID of the book to be retrieved") @PathVariable Long id) {
        BookDTO book = bookService.findBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    @Operation(summary = "Create a new book", description = "Add a new book to the bookstore")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created a new book",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<BookDTO> createBook(
        @Parameter(description = "Book information to be created") @Valid @RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        return ResponseEntity.status(201).body(createdBook);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing book", description = "Update details of an existing book")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated the book",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<BookDTO> updateBook(
        @Parameter(description = "ID of the book to be updated") @PathVariable Long id,
        @Parameter(description = "Updated book information") @Valid @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book", description = "Remove a book from the bookstore by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted the book", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public ResponseEntity<Void> deleteBook(
        @Parameter(description = "ID of the book to be deleted") @PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
