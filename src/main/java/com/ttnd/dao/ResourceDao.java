package com.ttnd.dao;

import com.ttnd.entity.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
}
