package com.lynas.dao;

import com.lynas.model.User;

/**
 * Base userDao interface for
 */
public interface UserDao {
    User loadUserByUsername(String username);

    long saveUser(User user);

    User get(long id);

}
