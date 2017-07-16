package com.ttnd.controller;

import com.ttnd.entity.User;
import com.ttnd.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserRegisterService userService;

    public void setUserService(UserRegisterService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index","user",new User());
    }

    @RequestMapping("/login")
    ModelAndView login(@Valid User user,BindingResult bindingResult, HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return new ModelAndView("index");
        }

        User userFetched=userService.check(user);
        if(userFetched!=null){
            request.getSession().setAttribute("username",userFetched.getFirstname());
            ModelAndView m=new ModelAndView("hello");
            m.addObject("user",userFetched);
            return m;
        }
        return new ModelAndView("index");
    }
}
