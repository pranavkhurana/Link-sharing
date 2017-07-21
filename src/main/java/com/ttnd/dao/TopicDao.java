package com.ttnd.dao;

import com.ttnd.entity.Topic;
import com.ttnd.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        session.beginTransaction();
        Query query=session.createQuery("from Topic where name=? and createdBy_userid=?");
        query.setParameter(0,topic.getName());
        query.setParameter(1,user.getUserid());
        query.setMaxResults(1);
        session.getTransaction().commit();
        List list=query.list();
        if(list.size()>0) {
            System.out.println("duplicate topic found for this user");
            return false;
        }
        else return true;
    }

    public Topic getTopic(int topicid){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
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
        session.beginTransaction();

        Query query=session.createQuery("select res.topic from Resource res group by res.topic having res.topic.visibility=0 order by count(res.resourceid) desc");
        query.setMaxResults(5);

        list=query.list();
        session.getTransaction().commit();

//        Trying join in Hql, but in vain
//        List<Topic> list2;
//        Query query2=session.createQuery("select A,B from (select res.topic,count(res.resourceid) from Resource res group by res.topic) as A join (select count(s.subscriptionid),s.topic from Subscription s group by s.topic) as B on A.topic=B.topic");
//        list2=query2.list();
//        for(int i=0;i<list2.size();i++){
//            System.out.println(list2.get(i));
//        }

        return list;
    }

    public List getAllTopicsForUser(User user,int pageno,int records){

        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("from Topic where createdBy=?");
        query.setParameter(0,user);
        query.setFirstResult(records*(pageno-1));
        query.setMaxResults(records);
        List list=query.list();
        session.getTransaction().commit();
        return list;
    }

    public Long getNoOfTopicsForUser(User user){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("select count(t.topicid) from Topic t where t.createdBy=?");
        query.setParameter(0,user);
        Long noOfTopics=(Long)query.uniqueResult();
        session.getTransaction().commit();
        return noOfTopics;
    }

    public void updateTopic(Topic topic){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.update(topic);
        session.getTransaction().commit();
    }

}
