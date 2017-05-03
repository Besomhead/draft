package com.admin4tg.auth.service;

import com.admin4tg.auth.model.User;

public interface UserService {

    User findByUsername(String username);
}
