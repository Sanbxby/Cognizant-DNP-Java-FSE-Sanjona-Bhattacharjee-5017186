

package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@ActiveProfiles("test")  // Use application-test.properties
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        bookRepository.deleteAll();
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Spring Boot in Action");
        bookDTO.setAuthor("Craig Walls");
        bookDTO.setPrice(39.99);
        bookDTO.setIsbn("978-1617292545");

        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Spring Boot in Action"))
                .andExpect(jsonPath("$.author").value("Craig Walls"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.setTitle("Spring Boot in Action");
        bookDTO1.setAuthor("Craig Walls");
        bookDTO1.setPrice(39.99);
        bookDTO1.setIsbn("978-1617292545");

        BookDTO bookDTO2 = new BookDTO();
        bookDTO2.setTitle("Java Concurrency in Practice");
        bookDTO2.setAuthor("Brian Goetz");
        bookDTO2.setPrice(49.99);
        bookDTO2.setIsbn("978-0321349606");

        bookRepository.save(bookDTO1.toEntity());
        bookRepository.save(bookDTO2.toEntity());

        mockMvc.perform(get("/api/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("Spring Boot in Action"))
                .andExpect(jsonPath("$[1].title").value("Java Concurrency in Practice"));
    }

    @Test
    public void testGetBookById() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Spring Boot in Action");
        bookDTO.setAuthor("Craig Walls");
        bookDTO.setPrice(39.99);
        bookDTO.setIsbn("978-1617292545");

        bookDTO = bookRepository.save(bookDTO.toEntity()).toDTO();

        mockMvc.perform(get("/api/books/{id}", bookDTO.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Spring Boot in Action"));
    }
}
