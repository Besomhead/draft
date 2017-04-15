package com.fortegroupe.service;

import com.fortegroupe.model.User;

/**
 * Created by sazzad on 2/11/16
 */
public interface UserService {
    User registerUser(User user);

    User getUserByEmail(User user);

    boolean checkEmail(String email);
}
