package com.ttnd.service;

import com.ttnd.dao.ResourceDao;
import com.ttnd.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    ResourceDao resourceDao;

    public ResourceDao getResourceDao() {
        return resourceDao;
    }

    public void setResourceDao(ResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }

    public boolean addResource(Resource resource){
        return resourceDao.addResource(resource);
    }

    public List getRecentPublicResources(int noOfResources){
        return resourceDao.getRecentPublicResources(noOfResources);
    }
}
