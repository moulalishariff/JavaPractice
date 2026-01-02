package com.example.repository;

import java.util.List;

import com.example.entity.User;

public interface UserRepository 
{
	User add(User user);
	List<User> list();
	User update(User user);
	boolean delete(long id);
	boolean deleteByName(String username);
	User getById(long id);
	User getByName(String username);
	
}
