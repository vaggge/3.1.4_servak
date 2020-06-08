package ru.javamentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.dao.UserDAO;
import ru.javamentor.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    @Override
    public List<User> listOfUsers() {
        return userDAO.listOfUsers();
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        boolean isAdded = false;
        if (!isUserExist(user)) {
            userDAO.addUser(user);
            isAdded = true;
        }
        return isAdded;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public boolean isUserExist(User user){
        return userDAO.isUserExist(user);
    }

    @Override
    public User getById(long id){
        return userDAO.getById(id);
    }

    @Override
    public User loadUserByUsername(String username){
        return userDAO.loadUserByUsername(username);
    }
}
