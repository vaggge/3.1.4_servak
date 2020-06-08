package ru.javamentor.service;

import ru.javamentor.model.User;

import java.util.List;


public interface UserService {

    List<User> listOfUsers();

    boolean addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    boolean isUserExist(User user);

    User getById(long id);

    User loadUserByUsername(String username);
}
