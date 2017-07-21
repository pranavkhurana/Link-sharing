package com.ttnd.dao;

import com.ttnd.entity.DocumentResource;
import com.ttnd.entity.LinkResource;
import com.ttnd.entity.Resource;
import com.ttnd.entity.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceDao {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean addResource(LinkResource resource){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(resource);
        session.getTransaction().commit();
        return true;
    }

    public boolean addResource(DocumentResource resource){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(resource);
        session.getTransaction().commit();
        return true;
    }

    public List getRecentPublicResources(int noOfResources){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
//        Query query=session.createQuery("select r,u.firstname,u.lastname,t.name from Resource r,User u,Topic t where r.topic=t and r.createdBy=u");
        Query query =session.createQuery("from Resource r where r.topic.visibility=0 order by dateCreated desc");
        query.setMaxResults(noOfResources);
        List list=query.list();
        session.getTransaction().commit();
        return list;
    }
    public List getPosts(Topic topic,int pageno,int noofrecords){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("from Resource where topic=? order by dateCreated desc");
        query.setParameter(0,topic);
        query.setFirstResult(noofrecords*(pageno-1));
        query.setMaxResults(noofrecords);
        List list=query.list();
        session.getTransaction().commit();
        return list;
    }
    public boolean deleteAllResourcesOfTopic(Topic topic){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("delete from Resource where topic=?");
        query.setParameter(0,topic);
        query.executeUpdate();
        session.getTransaction().commit();
        return true;
    }
}