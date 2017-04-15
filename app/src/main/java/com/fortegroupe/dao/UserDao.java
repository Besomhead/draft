package com.fortegroupe.dao;

import com.fortegroupe.model.User;

/**
 * That a dao interface we add some method to have contract
 * @author Alexey Burov
 * @version 0.1
 */
public interface UserDao {
    User registerUser(User user);

    User getUserByEmail(String email);

    public boolean checkEmail(String email);
}
