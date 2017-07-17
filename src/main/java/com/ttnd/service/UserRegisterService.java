package com.ttnd.service;

import com.ttnd.dao.UserDao;
import com.ttnd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
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

    public String addUser(User user){

        if(!user.getConfirmPassword().equals(user.getPassword()))
            return "Passwords do not match";

        int uniqueness=userDao.checkUsernameAndEmailUniqueness(user);

        if(uniqueness==0){
            user.setAdmin(false);
            Date date=new Date();
            user.setLastUpdated(date);
            user.setDateCreated(date);
            user.setActive(false);
            userDao.addUser(user);
            return "success";
        }
        else if(uniqueness==1)
            return "Username and Email not unique.";
        else if(uniqueness==2)
            return "Email already exists.";
        else return "Username already exists.";

    }
}
