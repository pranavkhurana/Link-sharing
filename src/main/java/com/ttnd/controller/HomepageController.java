package com.ttnd.controller;

import com.ttnd.entity.User;
import com.ttnd.service.ResourceService;
import com.ttnd.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
public class HomepageController extends ParentController {

    @Autowired
    UserRegisterService userService;

    @Autowired
    ResourceService resourceService;

    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public void setUserService(UserRegisterService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView home(){

        ModelAndView model1=new ModelAndView("index");

        //for login form
        model1.addObject("user",new User());

        //for registration form
        model1.addObject("user2",new User());

        //recent shares
        List list=resourceService.getRecentPublicResources(5);
        model1.addObject("recentPublicResources",list);

        return model1;
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    ModelAndView login(User user,HttpServletRequest request){

        //to use jsr validation here, a separate dto need to be made (skipping for now)

        //check user existence in db
        User userFetched=userService.check(user);
        if(userFetched!=null){
            request.getSession().setAttribute("user",userFetched);
            ModelAndView m=new ModelAndView("forward:/dashboard","popupMessage","<p style='color:green'>Welcome!</p>");
            return m;
        }
        return new ModelAndView("forward:/","loginMessage","Invalid Email or Password. Please try again.");
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    ModelAndView register(@RequestParam CommonsMultipartFile file, @Valid @ModelAttribute("user2") User user,BindingResult bindingResult, HttpSession session){

        if(bindingResult.hasErrors()){
            return new ModelAndView("forward:/");
        }

        //converting file to byte[] and storing in user object
        byte[] photo=null;
        if(!file.isEmpty())
            photo=file.getBytes();
        user.setPhoto(photo);

        ModelAndView model=new ModelAndView("forward:/");
        String status=userService.addUser(user);

        //setting registration status as message object
        if(status.equals("success"))
            model.addObject("registerMessage","<span style='color:green'>Registration successful. Login to proceed.</span>");
        else
            model.addObject("registerMessage","<span style='color:red'>"+status+"</span>");
        return model;

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return ("redirect:/");
    }

    @RequestMapping("/forgot-password")
    public ModelAndView forgotPassword(@RequestParam String email){

        ModelAndView model=new ModelAndView("forward:/");
        String message;

        String pass=userService.checkEmailPassword(email);

        if(pass!=null){
            message="<p style='color:green'>Reset password link sent to your email</p>";
            System.out.println("Reset your password here: localhost:8080/forgot-password/eNcRyPtEd"+pass+"");
        }
        else message="<p style='color:red'>Email-id is not registered.</p>";
        model.addObject("popupMessage",message);

        return model;
    }

    @RequestMapping("/forgot-password/{encpass}")
    public ModelAndView resetPasswd(@PathVariable String encpass){
        ModelAndView model=new ModelAndView("forgot-password-form");
        model.addObject("encpass",encpass);
        return model;
    }

    @RequestMapping("/change-passwd")
    public ModelAndView changePasswd(@RequestParam String encpass,@RequestParam String email,@RequestParam String password,@RequestParam String confirm){

        String message;
        String originalPass=userService.checkEmailPassword(email);
        String encOriginalPass="eNcRyPtEd"+originalPass+"";

        if(confirm!=password)
            message="Passwords do not match!";
        else if(encpass==encOriginalPass) {

            message = "Password reset successfully. Login with new password to proceed.";
        }else message="Invalid attempt";

        return new ModelAndView("forward:/dashboard","popupMessage",message);
    }
}
