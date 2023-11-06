package com.example.pp.dao;



import com.example.pp.entities.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User getUserById(int id);

    void removeUser(User user);

    void updateUser(User user);

    void addUser(User user);
}
