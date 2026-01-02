package com.example.repository;

import com.example.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private List<User> userList = new ArrayList<>();
    private int currentId = 1;

    @Override
    public User add(User user) {
        user.setId(currentId++);
        userList.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == user.getId()) {
                userList.set(i, user);
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return userList.removeIf(user -> user.getId() == id);
    }

    @Override
    public boolean deleteByName(String username) {
        return userList.removeIf(user -> user.getUsername().equalsIgnoreCase(username));
    }

    @Override
    public User getById(long id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getByName(String username) {
        return userList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> list() {
        return new ArrayList<>(userList);
    }
}
