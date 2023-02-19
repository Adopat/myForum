package com.justin.myForum.service;

import com.justin.myForum.domain.User;

public interface UserService {
    int register(User user);

    User login(String phone, String pwd);
}
