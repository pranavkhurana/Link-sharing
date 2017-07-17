package com.ttnd.controller;

import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import com.ttnd.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CreateTopicController {
    @Autowired
    TopicService topicService;

    public TopicService getTopicService() {
        return topicService;
    }

    @RequestMapping(value = "/create-topic",method = RequestMethod.POST)
    public ModelAndView createTopic(@ModelAttribute("topic")Topic topic,HttpSession session){
        boolean status=topicService.createTopic(topic,(User)session.getAttribute("user"));
        String message=null;
        if(status) message="<p style='color:green'>Topic created successfully.</p>";
        else message="<p style='color:red'>Topic with same name already exists.</p>";
        return new ModelAndView("forward:/dashboard","popupMessage",message);
    }
}
