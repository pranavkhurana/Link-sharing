package com.ttnd.service;

import com.ttnd.dao.TopicDao;
import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicDao topicDao;

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public boolean createTopic(Topic topic,User user){
        if(topicDao.checkTopicUniqueness(topic,user)){
            return topicDao.createTopic(topic,user);
        }
        return false;
    }

    public List getSubscribedTopics(User user){
        return topicDao.getSubscribedTopics(user);
    }
}
