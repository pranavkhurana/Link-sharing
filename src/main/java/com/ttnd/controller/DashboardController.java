package com.ttnd.controller;

import com.ttnd.entity.*;
import com.ttnd.service.SubscriptionService;
import com.ttnd.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class DashboardController extends ParentController {

    @Autowired
    TopicService topicService;

    @Autowired
    SubscriptionService subscriptionService;

    @RequestMapping(value="/dashboard")
    public ModelAndView showDashboard(HttpSession session){

        User user=(User)session.getAttribute("user");
        ModelAndView model=new ModelAndView("dashboard","popupMessage","<p style='color:red'>Please login first.</p>");

        if(user==null) return new ModelAndView("forward:/");

        //converting photo bytes[] into image
        if(user!=null&& user.getPhoto()!=null){
            String path=session.getServletContext().getRealPath("/");
            FileOutputStream fos=null;
            try {
                fos = new FileOutputStream(path+"resources/images/"+user.getUserid()+".jpg");
                fos.write(user.getPhoto());
                fos.close();
            }catch(Exception e) {
                System.out.println(e);
            }
        }

        //no of topics
        Long noOfTopics=topicService.getNoOfTopicsForUser(user);
        model.addObject("noOfTopics",noOfTopics);

        //no of Subscriptions
        Long noOfSubscriptions=subscriptionService.getNoOfSubscriptions(user);
        model.addObject("noOfSubscriptions",noOfSubscriptions);


        //user from session for displaying
        model.addObject("user",user);

        //subscribe form command
        //model.addObject("subscription",new Subscription());

        //trending topics
        List trendingTopicList=topicService.getTrendingTopics();
        model.addObject("trendingTopicList",trendingTopicList);

        return model;
    }
}
