package com.ruszkowski89.Spring;

import com.ruszkowski89.Spring.dao.CircleDao;
import com.ruszkowski89.Spring.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.SQLException;

public class SpringDataOverviewApp {
    public static void main(String args[]) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        CircleDao circleDao = context.getBean("circleDao", CircleDao.class);

        circleDao.insertCircle(new Circle(5, "5th circle"));
        /*List<Circle> list = jdbcDao.getListOfAllCircles();
        for (Circle circle : list){
            System.out.println(circle.getName());
        }*/


    }
}
