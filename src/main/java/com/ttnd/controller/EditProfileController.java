package com.ttnd.controller;

import com.ttnd.command.ProfileEditCommand;
import com.ttnd.entity.Subscription;
import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import com.ttnd.service.SubscriptionService;
import com.ttnd.service.TopicService;
import com.ttnd.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/edit-profile")
public class EditProfileController extends ParentController {

    @Autowired
    TopicService topicService;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    UserRegisterService userService;

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }

    @RequestMapping("")
    public ModelAndView editProfile(HttpSession session){

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
        profileEditCommand.setId(user.getUserid());
        model.addObject("profileEditCommand",profileEditCommand);

        //all topics of this user
        List allTopicsForUser=topicService.getAllTopicsForUser(user,1,5);
        model.addObject("allTopicsForUser",allTopicsForUser);

        //no of topics
        Long noOfTopics=topicService.getNoOfTopicsForUser(user);
        model.addObject("noOfTopics",noOfTopics);

        //no of Subscriptions
        Long noOfSubscriptions=subscriptionService.getNoOfSubscriptions(user);
        model.addObject("noOfSubscriptions",noOfSubscriptions);

        return model;
    }

    @RequestMapping("/edit")
    public ModelAndView register(@RequestParam CommonsMultipartFile file, @Valid @ModelAttribute("profileEditCommand") ProfileEditCommand profileEditCommand, BindingResult bindingResult, HttpSession session,@RequestParam String uri){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return new ModelAndView(uri);
        }

        //converting file to byte[] and storing in user object
        byte[] photo=null;
        if(!file.isEmpty())
            photo=file.getBytes();
        profileEditCommand.setPhoto(photo);

        ModelAndView model=new ModelAndView(uri);
        boolean status=userService.editUser(profileEditCommand);

        //setting registration status as message object
        if(status){
            session.setAttribute("user",userService.getUser(profileEditCommand.getId()));
            model.addObject("profileMessage","<span style='color:green'>Successfully edited</span>");
        }
        else
            model.addObject("profileMessage","<span style='color:red'>There was an error</span>");
        return model;

    }

    @RequestMapping("/change-password")
    public ModelAndView changePassword(@RequestParam String password, @RequestParam String confirm,@RequestParam String uri,@RequestParam int id,HttpSession session){

        String message;

        //if passwords do not match
        if(!confirm.equals(password)){
            message="<p style='color:red'>Passwords do not match!</p>";
            return new ModelAndView(uri,"changePasswordMessage",message);
        }
        else if(password.length()<8){
            return new ModelAndView(uri,"changePasswordMessage","Password too short");
        }
        else{
            userService.changePassword(id,password);
            session.invalidate();
            uri="forward:/";
            message="<p style='color:green'>Password changed! Login with new password to continue.</p>";
            return new ModelAndView("forward:/","popupMessage",message);
        }
    }

    @RequestMapping("/edit-topic-name")
    public ModelAndView editTopicName(@RequestParam String topicname,@RequestParam String uri,@RequestParam int id){
        String message;
        if(topicname!=null && !topicname.isEmpty()){
            Topic topic=topicService.getTopic(id);
            topic.setName(topicname);
            topicService.updateTopic(topic);
            message="<p style='color:green'>Updated successfully.</p>";
        }
        else message="<p style='color:red'>Some error occured!</p>";
        return new ModelAndView(uri,"popupMessage",message);
    }
    @RequestMapping("/edit-topic-visibility")
    public ModelAndView editTopicVisibility(@RequestParam int visibilityInt,@RequestParam String uri,@RequestParam int id){
        Topic topic=topicService.getTopic(id);
        if(visibilityInt==0) topic.setVisibility(Topic.Visibility.Public);
        else topic.setVisibility(Topic.Visibility.Private);
        topicService.updateTopic(topic);
        return new ModelAndView(uri,"popupMessage","<p style='color:green'>Updated successfully.</p>");
    }
    @RequestMapping(value = "/delete-topic",method = RequestMethod.POST)
    public String deleteTopic(@RequestParam int topicid,HttpSession session){

        User user=(User)session.getAttribute("user");
        Topic topic=topicService.getTopic(topicid);
        if(user.getUserid()==topic.getCreatedBy().getUserid()){
            if(topicService.deleteTopic(topic)){
                return "success";
            }
        }
        return "failed";
    }

    @RequestMapping(value="/paginate-topics",method=RequestMethod.POST)
    public ModelAndView fetchTopics(@RequestParam int pageno,HttpSession session){

        System.out.println("pageno requested:"+pageno);
        ModelAndView model=new ModelAndView("pagination/edit-profile-topic");

        //no of records per page
        int noOfRecords=5;
        model.addObject("recordsPerPage",noOfRecords);

        //user
        User user=(User)session.getAttribute("user");
        model.addObject("user",user);

        //no of topics
        Long noOfTopics=topicService.getNoOfTopicsForUser(user);
        model.addObject("noOfTopics",noOfTopics);

        //check if pageno exeeded
        if(pageno==-1 || pageno > ((noOfTopics/noOfRecords)+1))
            pageno=1;
        model.addObject("pageNo",pageno);

        //all topics of this user
        List allTopicsForUser=topicService.getAllTopicsForUser(user, pageno,noOfRecords);
        model.addObject("allTopicsForUser",allTopicsForUser);

        //no of Subscriptions
        Long noOfSubscriptions=subscriptionService.getNoOfSubscriptions(user);
        model.addObject("noOfSubscriptions",noOfSubscriptions);

        System.out.println("List served"+allTopicsForUser);
        return model;
    }
}

