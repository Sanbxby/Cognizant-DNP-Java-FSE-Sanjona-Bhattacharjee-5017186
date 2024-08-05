package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void findAllBooks() {
        System.out.println("Finding all books in the repository...");
    }
}
