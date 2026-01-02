package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.add(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean deleteUser(long id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean deleteUserByName(String username) {
        return userRepository.deleteByName(username);
    }

    @Override
    public User searchUserById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public User searchUserByName(String username) {
        return userRepository.getByName(username);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.list();
    }
}