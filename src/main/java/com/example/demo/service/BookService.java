package com.example.demo.service;

import com.example.demo.models.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAllBooks();
    public Book getBookById(Long id);
    public Book addBook(Book book);
    public Book updateBook(Long id, Book book);
    public void deleteBook(Long id);
}
