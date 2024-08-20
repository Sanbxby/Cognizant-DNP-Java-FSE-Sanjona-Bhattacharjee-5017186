

package com.example.bookstore.assembler;

import com.example.bookstore.controller.BookController;
import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BookModelAssembler implements RepresentationModelAssembler<Book, BookDTO> {

    private final ModelMapper modelMapper;

    public BookModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO toModel(Book book) {
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);

        // Add self link
        bookDTO.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());

        // Add link to all books
        bookDTO.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));

        return bookDTO;
    }

    @Override
    public CollectionModel<BookDTO> toCollectionModel(Iterable<? extends Book> entities) {
        CollectionModel<BookDTO> bookDTOs = RepresentationModelAssembler.super.toCollectionModel(entities);

        // Add link to create a new book
        bookDTOs.add(linkTo(methodOn(BookController.class).createBook(null)).withRel("create"));

        return bookDTOs;
    }
}
