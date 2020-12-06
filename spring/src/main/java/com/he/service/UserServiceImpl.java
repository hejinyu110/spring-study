package com.he.service;

import com.he.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser(){
        System.out.println("获取用户对象");
    }

}
