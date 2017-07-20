package com.ttnd.controller;

import com.ttnd.entity.*;
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

    @RequestMapping(value="/dashboard",method= RequestMethod.POST)
    public ModelAndView showDashboard(HttpSession session){

        User user=(User)session.getAttribute("user");
        ModelAndView model=new ModelAndView("dashboard");

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

        //create-document form command
        //model.addObject("documentResource",new DocumentResource());

        //create-link form command
        //model.addObject("linkResource",new LinkResource());

        //user from session for displaying
        model.addObject("user",user);

        //create-topic form command
        //model.addObject("topic",new Topic());

        //subscribe form command
        //model.addObject("subscription",new Subscription());

        //subscribed topics
//        List subscribedTopicList=topicService.getSubscribedTopics(user);
//        model.addObject("subscribedTopicList",subscribedTopicList);

        //trending topics
        List trendingTopicList=topicService.getTrendingTopics();
        model.addObject("trendingTopicList",trendingTopicList);

        return model;
    }
}
