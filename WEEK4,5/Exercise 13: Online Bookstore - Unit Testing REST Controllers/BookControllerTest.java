

package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    private BookDTO bookDTO;

    @BeforeEach
    public void setUp() {
        bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setTitle("Effective Java");
        bookDTO.setAuthor("Joshua Bloch");
        bookDTO.setPrice(45.00);
        bookDTO.setIsbn("978-0134685991");
    }

    @Test
    public void testGetAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(bookDTO));

        mockMvc.perform(get("/api/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Effective Java"));

        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    public void testGetBookById() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(bookDTO);

        mockMvc.perform(get("/api/books/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java"));

        verify(bookService, times(1)).getBookById(1L);
    }

    @Test
    public void testCreateBook() throws Exception {
        when(bookService.createBook(any(BookDTO.class))).thenReturn(bookDTO);

        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Effective Java\",\"author\":\"Joshua Bloch\",\"price\":45.00,\"isbn\":\"978-0134685991\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Effective Java"));

        verify(bookService, times(1)).createBook(any(BookDTO.class));
    }

    @Test
    public void testUpdateBook() throws Exception {
        when(bookService.updateBook(eq(1L), any(BookDTO.class))).thenReturn(bookDTO);

        mockMvc.perform(put("/api/books/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Effective Java\",\"author\":\"Joshua Bloch\",\"price\":45.00,\"isbn\":\"978-0134685991\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java"));

        verify(bookService, times(1)).updateBook(eq(1L), any(BookDTO.class));
    }

    @Test
    public void testDeleteBook() throws Exception {
        doNothing().when(bookService).deleteBook(1L);

        mockMvc.perform(delete("/api/books/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(bookService, times(1)).deleteBook(1L);
    }
}
