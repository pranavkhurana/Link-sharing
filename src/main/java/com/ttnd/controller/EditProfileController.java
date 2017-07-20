package com.ttnd.controller;

import com.ttnd.command.ProfileEditCommand;
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
@RequestMapping("/edit-profile")
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

    @RequestMapping("")
    public ModelAndView editProfile(HttpSession session){

        System.out.println("hello");
        ModelAndView model=new ModelAndView("edit-profile");

        //user
        User user=(User)session.getAttribute("user");
        model.addObject("user",user);

        //not logged in user
        if(user==null){
            return new ModelAndView("forward:/","popupMessage","<p style='color:red'>Please login first</p>");
        }

        //profile edit command populated to display values in form as placeholder
        ProfileEditCommand profileEditCommand=new ProfileEditCommand();
        profileEditCommand.setFirstname(user.getFirstname());
        profileEditCommand.setLastname(user.getLastname());
        profileEditCommand.setUsername(user.getUsername());
        profileEditCommand.setPhoto(user.getPhoto());
        model.addObject("profileEditCommand",profileEditCommand);

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
