package com.ttnd.controller;

import com.ttnd.entity.LinkResource;
import com.ttnd.entity.Resource;
import com.ttnd.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddResourceController {

    @Autowired
    ResourceService resourceService;

    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @RequestMapping("/add-resource")
    public boolean addResource(){
//        LinkResource resource=new LinkResource();
//        resource.setUrl("facebook.com");
//        resource.setTopic();
//        resource.setCreatedBy();
//        resourceService.addResource();
        return true;
    }
}
