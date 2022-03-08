package com.sise.service.impl;

import com.sise.dao.UserDao;
import com.sise.pojo.User;
import com.sise.service.UserService;
import com.sise.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findUsernameAndPassword(String username, String password) {
        User user = userDao.findUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
