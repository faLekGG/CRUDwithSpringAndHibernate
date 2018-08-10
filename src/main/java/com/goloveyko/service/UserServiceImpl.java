package com.goloveyko.service;

import com.goloveyko.dao.UserDAO;
import com.goloveyko.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    /*@Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }*/

    @Override
    @Transactional
    public List<User> searchUsers(String theSearchName) {

        return userDAO.searchUsers(theSearchName);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> users() {
        return userDAO.users();
    }
}
