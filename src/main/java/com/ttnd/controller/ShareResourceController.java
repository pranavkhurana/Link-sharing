package com.ttnd.controller;

import com.ttnd.entity.DocumentResource;
import com.ttnd.entity.LinkResource;
import com.ttnd.entity.User;
import com.ttnd.service.ShareResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ShareResourceController {

    @Autowired
    ShareResourceService shareResourceService;

    public void setShareResourceService(ShareResourceService shareResourceService) {
        this.shareResourceService = shareResourceService;
    }

    @RequestMapping("/share-document")
    public void shareDocument(@Valid @ModelAttribute DocumentResource documentResource,BindingResult bindingResult){
        //shareResourceService.save(resource)
    }

    @RequestMapping("/share-link")
    public ModelAndView shareLink(@ModelAttribute("linkResource") @Valid LinkResource linkResource, BindingResult bindingResult,HttpSession session){
        User user=(User)session.getAttribute("user");
        String popupMessage=null;
        if(bindingResult.hasErrors()){
            popupMessage="Fields can't be empty.";
            System.out.println(bindingResult.getAllErrors());;
        }
        else{
            boolean status=shareResourceService.addLinkResource(linkResource,user);
            if(status) popupMessage="<p style='color:green'>Resource shared!</p>";
            else popupMessage="<p style='color:red'>There was an error.</p>";
        }
        return new ModelAndView("forward:/dashboard","popupMessage", popupMessage);
    }

}
