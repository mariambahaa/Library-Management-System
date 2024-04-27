package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private BookService bookService;

        @Test
        public void testGetBooks_shouldReturnAllBooks() throws Exception {
            List<Book> books = Arrays.asList(new Book(1L, "Book Title 1", "Joe", 2023, "333"));
            Mockito.when(bookService.findAllBooks()).thenReturn(books);

            mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").isArray())  // Assert response is a JSON array using JsonPath
                    .andExpect(jsonPath("$[0].title").value("Book Title 1"));
        }
}
