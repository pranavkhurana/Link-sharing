package com.ttnd.dao;

import com.ttnd.entity.DocumentResource;
import com.ttnd.entity.LinkResource;
import com.ttnd.entity.Resource;
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

    public boolean addResource(Resource resource){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(resource);
        session.getTransaction().commit();
        return true;
    }
    public List getRecentPublicResources(int noOfResources){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("from Resource order by dateCreated desc");
        query.setMaxResults(noOfResources);
        Query query2=session.createQuery()
        List list=query.list();
        return list;
    }
}