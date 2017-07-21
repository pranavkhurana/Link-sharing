package com.ttnd.service;

import com.sun.org.glassfish.gmbal.InheritedAttribute;
import com.ttnd.dao.ResourceDao;
import com.ttnd.dao.SubscriptionDao;
import com.ttnd.dao.TopicDao;
import com.ttnd.entity.Subscription;
import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicDao topicDao;

    @Autowired
    SubscriptionDao subscriptionDao;

    @Autowired
    ResourceDao resourceDao;

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public void setSubscriptionDao(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    public boolean createTopic(Topic topic, User user){

        if(topicDao.checkTopicUniqueness(topic,user)){

            //creating topic
            topicDao.createTopic(topic,user);

            //creating new subsciption
            Subscription subscription=new Subscription();
            subscription.setUser(user);
            subscription.setTopic(topic);
            subscription.setSeriousness(Subscription.Seriousness.Casual);
            subscription.setDateCreated(new Date());

            //subscribing user to his own topic
            return subscriptionDao.addSubscription(subscription);

        }
        return false;
    }

    public List getSubscribedTopics(User user){
        return subscriptionDao.getSubscribedTopics(user);
    }

    public List getTrendingTopics(){
        return topicDao.getTrendingTopics();
    }

    public Topic getTopic(int topicid){
        return topicDao.getTopic(topicid);
    }

    public boolean getSubscriptionStatus(User user,Topic topic){
        return subscriptionDao.getSubscriptionStatus(user,topic);
    }
    public List getSubscribers(Topic topic,int pageno,int noofrecords){
        return subscriptionDao.getSubscribers(topic,pageno,noofrecords);
    }

    public List getAllTopicsForUser(User user,int pageno,int records){
        return topicDao.getAllTopicsForUser(user,pageno,records);
    }

    public Long getNoOfTopicsForUser(User user){
        return topicDao.getNoOfTopicsForUser(user);
    }

    public void updateTopic(Topic topic){
        topicDao.updateTopic(topic);
    }

    public boolean deleteTopic(Topic topic){
        if(subscriptionDao.deleteAllSubscriptionsOfTopic(topic)&&resourceDao.deleteAllResourcesOfTopic(topic))
            return topicDao.deleteTopic(topic);
        else return false;
    }
}

