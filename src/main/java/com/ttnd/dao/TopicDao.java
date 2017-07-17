package com.ttnd.dao;

import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TopicDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean createTopic(Topic topic, User user){
        Date date=new Date();
        topic.setCreatedBy(user);
        topic.setDateCreated(date);
        topic.setLastUpdated(date);
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(topic);
        session.getTransaction().commit();
        return true;
    }
    public boolean checkTopicUniqueness(Topic topic,User user){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Topic where name=? and createdBy_userid=?");
        query.setParameter(0,topic.getName());
        query.setParameter(1,user.getUserid());
        query.setMaxResults(1);
        List list=query.list();
        if(list.size()>0) {
            System.out.println("duplicate topic found this user");
            return false;
        }
        else return true;
    }
    public List getSubscribedTopics(User user){
        List<Topic> list=new ArrayList<Topic>();
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Topic");  //to test only. change later to get only subscribed ones
        list=query.list();
        return list;
    }
}
