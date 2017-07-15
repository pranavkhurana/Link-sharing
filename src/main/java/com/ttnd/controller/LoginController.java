package com.ttnd.controller;

import com.ttnd.entity.User;
import com.ttnd.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserRegisterService userService;

    public void setUserService(UserRegisterService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    ModelAndView login(User user, HttpServletRequest request){

        User userFetched=userService.check(user);
        if(userFetched!=null){
            request.getSession().setAttribute("username",userFetched.getFirstname());
            ModelAndView model=new ModelAndView("hello");
            model.addObject("user",userFetched);
            return model;
        }
        return new ModelAndView("index");
    }
}
