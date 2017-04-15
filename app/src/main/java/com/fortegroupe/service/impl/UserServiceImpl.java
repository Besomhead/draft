package com.fortegroupe.service.impl;

import com.fortegroupe.dao.UserDao;
import com.fortegroupe.model.User;
import com.fortegroupe.service.UserService;
import com.fortegroupe.utill.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sazzad on 2/11/16
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User registerUser(User user) {
        String password = PasswordHelper.encryptPassword(user.getPassword());
        user.setPassword(password);
        return userDao.registerUser(user);
    }

    @Override
    public User getUserByEmail(User user) {
        if(user.getPassword()!= null) {
            String password = PasswordHelper.encryptPassword(user.getPassword());
            User daoUser = userDao.getUserByEmail(user.getEmail());
            if (daoUser != null && password.equals(daoUser.getPassword()))
                return daoUser;
            return null;
        }
        return null;
    }

    @Override
    public boolean checkEmail(String email) {
        return userDao.checkEmail(email);
    }

}
