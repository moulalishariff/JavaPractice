package com.example.repository;


import com.example.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private List<Book> bookList = new ArrayList<>();
    private int currentId = 1;

    @Override
    public Book add(Book book) {
        book.setId(currentId++);
        bookList.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == book.getId()) {
                bookList.set(i, book);
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return bookList.removeIf(book -> book.getId() == id);
    }

    @Override
    public boolean deleteByTitle(String title) {
        return bookList.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    @Override
    public Book getById(long id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book getByTitle(String title) {
        return bookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> list() {
        return new ArrayList<>(bookList);
    }
}