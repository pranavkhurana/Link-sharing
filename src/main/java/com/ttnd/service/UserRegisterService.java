package com.ttnd.service;

import com.ttnd.dao.UserDao;
import com.ttnd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterService {

    @Autowired
    UserDao userDao;


    public UserRegisterService() {
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User check(User user){
        return userDao.check(user);
    }
}
