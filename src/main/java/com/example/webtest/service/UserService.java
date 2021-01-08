package com.example.webtest.service;

import com.example.webtest.dao.UserDao;
import com.example.webtest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUser(int id){
        return userDao.Sel(id);
    }

    public boolean addUser(String userName, String passWord, String realName){
        return userDao.Add(userName, passWord, realName);
    }

    public User getUserByName(String userName){
        return userDao.getByName(userName);
    }
}
