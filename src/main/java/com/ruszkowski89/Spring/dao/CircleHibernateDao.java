package com.ruszkowski89.Spring.dao;

import com.ruszkowski89.Spring.model.Circle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@EnableTransactionManagement
@Transactional
@Repository

public class CircleHibernateDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void insertCircle(Circle circle){
        getSessionFactory().getCurrentSession().save(circle);
    }

    public String getCircleName(int id){
        String hql = "SELECT name from Circle where id=:id";
        Query query = getSessionFactory().openSession().createQuery(hql);
        query.setParameter("id", id);
        return (String)query.getSingleResult();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
