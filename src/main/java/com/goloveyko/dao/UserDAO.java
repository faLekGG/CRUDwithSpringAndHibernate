package com.goloveyko.dao;

import com.goloveyko.entity.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    //void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> users();
    List<User> searchUsers(String theSearchName);
}
