package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.add(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public boolean deleteBook(long id) {
        return bookRepository.delete(id);
    }

    @Override
    public boolean deleteBookByTitle(String title) {
        return bookRepository.deleteByTitle(title);
    }

    @Override
    public Book searchBookById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book searchBookByTitle(String title) {
        return bookRepository.getByTitle(title);
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.list();
    }
}