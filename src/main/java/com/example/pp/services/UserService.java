package com.example.pp.services;



import com.example.pp.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);


    void removeUser(User user);

    void updateUser(User user);

    void addUser(User user);

}
