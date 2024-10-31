package com.omji.users.user.service;

import com.omji.users.user.dao.UserDAO;
import com.omji.users.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User getUserById(Integer id) {
        return userDAO.findById(id);
    }

    public void addUser(User user) {
        userDAO.save(user);
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void deleteUser(Integer id) {
        userDAO.deleteById(id);
    }
}
