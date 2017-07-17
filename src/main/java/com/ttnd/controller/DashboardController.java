package com.ttnd.controller;

import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @RequestMapping(value="/dashboard",method= RequestMethod.POST)
    public ModelAndView showDashboard(HttpSession session){
        System.out.println("helllo");
        ModelAndView model=new ModelAndView("dashboard");
        model.addObject("user",(User)session.getAttribute("user"));
        model.addObject("topic",new Topic());
        return model;

    }
}
