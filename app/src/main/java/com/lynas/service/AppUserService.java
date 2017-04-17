package com.lynas.service;

import com.lynas.model.User;

/**
 * Created by LynAs on 20-Mar-16
 */
public interface AppUserService {
    User loadUserByUsername(String username);

    User  saveUser(User user);

    User get(long id);

}
