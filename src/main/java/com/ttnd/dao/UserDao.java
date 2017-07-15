package com.ttnd.dao;

import com.ttnd.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    public SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User check(User user){

        /*User u=new User();
        u.setFirstname("anurag");u.setEmail("anu@gmail.com");u.setPassword("abcd");
        Session session2=sessionFactory.openSession();
        session2.beginTransaction();
        session2.save(u);
        session2.getTransaction().commit();*/


        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from User where email=? and password=?");
        query.setParameter(0,user.getEmail());
        query.setParameter(1,user.getPassword());
        query.setMaxResults(1);
        List list=query.list();
        session.getTransaction().commit();
        if(list.size()>0)
            return (User)list.get(0);
        return null;
    }
}
