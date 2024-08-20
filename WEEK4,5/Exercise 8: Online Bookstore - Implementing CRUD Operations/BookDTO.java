

package com.example.bookstore.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookDTO {

    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotNull(message = "Author cannot be null")
    @Size(min = 2, max = 100, message = "Author must be between 2 and 100 characters")
    private String author;

    @Min(value = 0, message = "Price must be positive")
    private double price;

    @NotNull(message = "ISBN cannot be null")
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;


}
