package com.ruszkowski89.Spring;

import com.ruszkowski89.Spring.dao.CircleDao;
import com.ruszkowski89.Spring.dao.CircleHibernateDao;
import com.ruszkowski89.Spring.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.SQLException;

public class SpringDataOverviewApp {
    public static void main(String args[]) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        CircleHibernateDao circleHibernateDao = context.getBean("circleHibernateDao", CircleHibernateDao.class);

        for (int i=1; i<11; i++) {
            Circle circle = new Circle();
            circle.setName("Circle " + i);
            circle.setId(i);
            circleHibernateDao.insertCircle(circle);
        }

        System.out.println(circleHibernateDao.getCircleName(5));
        /*List<Circle> list = jdbcDao.getListOfAllCircles();
        for (Circle circle : list){
            System.out.println(circle.getName());
        }*/


    }
}
