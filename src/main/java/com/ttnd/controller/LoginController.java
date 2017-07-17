package com.ttnd.controller;

import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import com.ttnd.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    UserRegisterService userService;

    public void setUserService(UserRegisterService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView model1=new ModelAndView("index");
        model1.addObject("user",new User());
        model1.addObject("user2",new User());
        return model1;
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    ModelAndView login(User user,HttpServletRequest request){

        //to use binding result here make separate LoginCommand Dto
        User userFetched=userService.check(user);
        if(userFetched!=null){
            request.getSession().setAttribute("user",userFetched);
            ModelAndView m=new ModelAndView("forward:/dashboard");
            return m;
        }
        return new ModelAndView("forward:/","loginMessage","Invalid Email or Password. Please try again.");
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    ModelAndView register(@RequestParam CommonsMultipartFile file, @Valid @ModelAttribute("user2") User user,BindingResult bindingResult, HttpSession session){

        if(bindingResult.hasErrors()){
            return new ModelAndView("index");
        }

        byte[] photo=null;
        if(!file.isEmpty())
            photo=file.getBytes();
        user.setPhoto(photo);

        ModelAndView model=new ModelAndView("index");
        String status=userService.addUser(user);

        if(status.equals("success"))
            model.addObject("registerMessage","<span style='color:green'>Registration successful. Login to proceed.</span>");
        else
            model.addObject("registerMessage","<span style='color:red'>"+status+"</span>");
        return model;

        /*String path=session.getServletContext().getRealPath("/");
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(path+"resources/images/"+user.getEmail()+".jpg");
            fos.write(photo);
            fos.close();
        }catch(Exception e) {
            System.out.println(e);
        }*/
    }
}
