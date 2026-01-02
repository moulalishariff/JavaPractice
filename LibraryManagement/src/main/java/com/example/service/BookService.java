package com.example.service;

import com.example.entity.Book;
import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book);
    boolean deleteBook(long id);
    boolean deleteBookByTitle(String title);
    Book searchBookById(long id);
    Book searchBookByTitle(String title);
    List<Book> listBooks();
}