package com.ruszkowski89.Spring;

import com.ruszkowski89.Spring.dao.JdbcDao;
import com.ruszkowski89.Spring.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class SpringDataOverviewApp {
    public static void main(String args[]) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        JdbcDao jdbcDao = context.getBean("jdbcDao", JdbcDao.class);

        /*List<Circle> list = jdbcDao.getListOfAllCircles();
        for (Circle circle : list){
            System.out.println(circle.getName());
        }*/


    }
}
