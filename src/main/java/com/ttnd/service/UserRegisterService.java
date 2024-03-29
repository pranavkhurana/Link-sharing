package com.ttnd.service;

import com.ttnd.command.ProfileEditCommand;
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
    public boolean editUser(ProfileEditCommand profileEditCommand){
        User editedUser=new User();
        editedUser.setFirstname(profileEditCommand.getFirstname());
        editedUser.setLastname(profileEditCommand.getLastname());
        editedUser.setPhoto(profileEditCommand.getPhoto());
        editedUser.setUsername(profileEditCommand.getUsername());
        editedUser.setUserid(profileEditCommand.getId());
        editedUser.setLastUpdated(new Date());
        return userDao.editUser(editedUser);
    }

    public User getUser(int id){
        return userDao.getUser(id);
    }

    public void changePassword(int id,String password){
        userDao.changePassword(id,password);
    }

    public String checkEmailPassword(String email){
        return userDao.checkEmailPassword(email);
    }


}
