package com.ttnd.controller;

import com.ttnd.entity.Subscription;
import com.ttnd.entity.User;
import com.ttnd.service.SubscriptionService;
import com.ttnd.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EditProfileController extends BaseController{

    @Autowired
    TopicService topicService;

    @Autowired
    SubscriptionService subscriptionService;

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }

    @RequestMapping("/edit-profile")
    public ModelAndView editProfile(HttpSession session){

        ModelAndView model=new ModelAndView("edit-profile");

        //user
        User user=(User)session.getAttribute("user");
        model.addObject("user",user);

        //not logged in user
        if(user==null){
            return new ModelAndView("forward:/","popupMessage","<p style='color:red'>Please login first</p>");
        }

        //all topics of this user
        List allTopicsForUser=topicService.getAllTopicsForUser(user,1,10);
        model.addObject("allTopicsForUser",allTopicsForUser);

        //no of topics
        Long noOfTopics=topicService.getNoOfTopicsForUser(user);
        model.addObject("noOfTopics",noOfTopics);

        //no of Subscriptions
        Long noOfSubscriptions=subscriptionService.getNoOfSubscriptions(user);
        model.addObject("noOfSubscriptions",noOfSubscriptions);

        return model;
    }
}
