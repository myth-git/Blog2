package com.sise.service;


import com.sise.pojo.User;

public interface UserService {
    User findUsernameAndPassword(String username,String password);
}
