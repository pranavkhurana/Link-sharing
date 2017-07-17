package com.ttnd.controller;

import com.ttnd.entity.DocumentResource;
import com.ttnd.entity.LinkResource;
import com.ttnd.service.ShareResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView shareLink(@Valid @ModelAttribute LinkResource linkResource,BindingResult bindingResult){
        String popupMessage=null;
        if(bindingResult.hasErrors()){
            popupMessage="Fields can't be empty.";
            System.out.println(bindingResult.getAllErrors());;
        }
        else{
            System.out.println("hello");
            boolean status=shareResourceService.addLinkResource(linkResource);
            if(status) popupMessage="<p style='color:blue'>Resource shared!</p>";
            else popupMessage="<p style='color:red'>There was an error.</p>";
        }
        return new ModelAndView("forward:/dashboard","popupMessage", popupMessage);
    }

}
