package com.ttnd.controller;

import com.ttnd.entity.DocumentResource;
import com.ttnd.entity.LinkResource;
import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import com.ttnd.service.ShareResourceService;
import com.ttnd.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

@Controller
public class NavbarController extends ParentController {
    @Autowired
    TopicService topicService;

    @Autowired
    ShareResourceService shareResourceService;

    public void setShareResourceService(ShareResourceService shareResourceService) {
        this.shareResourceService = shareResourceService;
    }

    public TopicService getTopicService() {
        return topicService;
    }

    @RequestMapping(value = "/create-topic",method = RequestMethod.POST)
    public ModelAndView createTopic(@ModelAttribute("topic")Topic topic, HttpSession session, @RequestParam String uri){

        topic.setName(topic.getName().substring(0,1).toUpperCase()+""+topic.getName().substring(1).toLowerCase());

        boolean status=topicService.createTopic(topic,(User)session.getAttribute("user"));
        String message=null;

        if(status) message="<p style='color:green'>Topic created successfully.</p>";
        else message="<p style='color:red'>Topic with same name already exists.</p>";

        ModelAndView model;
        if(uri!=null)
            model=new ModelAndView(uri);
        else model=new ModelAndView("forward:/dashboard");

        model.addObject("popupMessage",message);
        return model;
    }

    @RequestMapping("/share-document")
    public ModelAndView shareDocument(@Valid @ModelAttribute DocumentResource documentResource, BindingResult bindingResult, HttpSession session, @RequestParam MultipartFile file, @RequestParam String uri){

        User user=(User)session.getAttribute("user");
        String popupMessage=null;

        //checking for binding errors
        if(bindingResult.hasErrors()||file.isEmpty()){
            popupMessage="Fields can't be empty.";
            System.out.println(bindingResult.getAllErrors());;
        }

        else{

            //getting path to save file
            String path=session.getServletContext().getRealPath("/")+"resources/documents/";

            //saving file on above path from path recieved in form:(localFilePath)
            String filePath=saveFile(file,path);

            //setting filePath in documentResource
            documentResource.setFilePath(filePath);

            //saving documentResource
            boolean status=shareResourceService.addDocumentResource(documentResource,user);

            //display message
            if(status) popupMessage="<p style='color:green'>Resource shared!</p>";
            else popupMessage="<p style='color:red'>There was an error.</p>";

        }

        ModelAndView model;
        if(uri!=null) model=new ModelAndView(uri);
        else model=new ModelAndView("forward:/dashboard");

        model.addObject("popupMessage", popupMessage);
        return model;
    }

    @RequestMapping("/share-link")
    public ModelAndView shareLink(@ModelAttribute("linkResource") @Valid LinkResource linkResource, BindingResult bindingResult, HttpSession session, @RequestParam String uri){

        User user=(User)session.getAttribute("user");
        String popupMessage=null;

        //check for binding errors
        if(bindingResult.hasErrors()){
            popupMessage="Fields can't be empty.";
            System.out.println(bindingResult.getAllErrors());;
        }
        else{

            //save linkResource
            boolean status=shareResourceService.addLinkResource(linkResource,user);

            //display message
            if(status) popupMessage="<p style='color:green'>Resource shared!</p>";
            else popupMessage="<p style='color:red'>There was an error.</p>";

        }

        ModelAndView model;
        if(uri!=null) model=new ModelAndView(uri);
        else model=new ModelAndView("forward:/dashboard");

        model.addObject("popupMessage",popupMessage);
        return model;
    }


    public String saveFile(MultipartFile file,String path){

        String filename=file.getOriginalFilename();
        System.out.println(path+" "+filename);
        try{
            byte barr[]=file.getBytes();
            BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+""+filename));
            bout.write(barr);
            bout.flush();
            bout.close();
        }catch(Exception e){System.out.println(e);}
        return path+""+filename;

    }
}
