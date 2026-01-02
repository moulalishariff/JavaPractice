package com.example.repository;

import java.util.List;

import com.example.entity.Book;

public interface BookRepository {

	Book add(Book book);
	List<Book> list();
	Book update(Book book);
	boolean delete(long id);
	boolean deleteByTitle(String title);
	Book getById(long id);
	Book getByTitle(String title);

}
