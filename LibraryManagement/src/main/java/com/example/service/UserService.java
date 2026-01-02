package com.example.service;

import com.example.entity.User;
import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    boolean deleteUser(long id);
    boolean deleteUserByName(String username);
    User searchUserById(long id);
    User searchUserByName(String username);
    List<User> listUsers();
}