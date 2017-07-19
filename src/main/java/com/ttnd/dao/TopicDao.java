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
            System.out.println("duplicate topic found for this user");
            return false;
        }
        else return true;
    }
    public List getSubscribedTopics(User user){
        List<Topic> list;
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Topic order by dateCreated desc");  //to test only. change later to get only subscribed ones
        list=query.list();
        return list;
    }
    public Topic getTopic(int topicid){
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Topic where topicid=?");
        query.setParameter(0,topicid);
        query.setMaxResults(1);
        List list=query.list();
        session.getTransaction().commit();
        return (Topic)list.get(0);
    }
    public List getTrendingTopics(){
        List<Topic> list;
        Session session=sessionFactory.openSession();

        Query query=session.createQuery("select res.topic from Resource res group by res.topic having res.topic.visibility=0 order by count(res.resourceid) desc");
        query.setMaxResults(5);

        list=query.list();

//        List<Topic> list2;
//        Query query2=session.createQuery("select A,B from (select res.topic,count(res.resourceid) from Resource res group by res.topic) as A join (select count(s.subscriptionid),s.topic from Subscription s group by s.topic) as B on A.topic=B.topic");
//        list2=query2.list();
//        for(int i=0;i<list2.size();i++){
//            System.out.println(list2.get(i));
//        }

        return list;
    }
}
