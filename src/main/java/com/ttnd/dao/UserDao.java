package com.ttnd.dao;

import com.ttnd.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
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

    public boolean addUser(User user){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return true;
    }

    public int checkUsernameAndEmailUniqueness(User user){

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from User where email=?");
        query.setParameter(0,user.getEmail());
        query.setMaxResults(1);
        List list=query.list();

        Query query1=session.createQuery("from User where username=?");
        query1.setParameter(0,user.getUsername());
        query1.setMaxResults(1);
        List list1=query1.list();

        session.getTransaction().commit();
        if(list.size()>0 && list1.size()>0)
            return 1;
        else if(list.size()>0 || list1.size()>0){
            if(list.size()>0)
                return 2;
            return 3;
        }
        return 0;
    }

    public boolean editUser(User user){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        System.out.println(user);
        Query query=session.createQuery("update User set firstname=?,lastname=?,username=?,photo=?,lastUpdated=? where userid=?");
        query.setParameter(0,user.getFirstname());
        query.setParameter(1,user.getLastname());
        query.setParameter(2,user.getUsername());
        query.setParameter(3,user.getPhoto());
        query.setParameter(4,user.getLastUpdated());
        query.setParameter(5,user.getUserid());
        query.executeUpdate();

        session.getTransaction().commit();
        return true;
    }

    public User getUser(int id){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,id);
        session.getTransaction().commit();
        System.out.println("in dao :"+user);
        return user;
    }
    public void changePassword(int id,String password){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("update User set password=?,lastUpdated=? where userid=?");
        query.setParameter(0,password);
        query.setParameter(1,new Date());
        query.setParameter(2,id);
        query.executeUpdate();
        session.getTransaction().commit();
    }
}
