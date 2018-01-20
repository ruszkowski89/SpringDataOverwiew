package com.ruszkowski89.Spring.dao;

import com.ruszkowski89.Spring.model.Circle;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class CircleDao extends JdbcDaoSupport {

    public void insertCircle(Circle circle){
        String sql = "INSERT INTO circle (id, name) values (?, ?)";
        getJdbcTemplate().update(sql, circle.getId(), circle.getName());
    }

    public void updateCircleName(int id, String newName){
        String sql = "UPDATE circle SET name='" + newName + "' WHERE id=" + id;
        getJdbcTemplate().update(sql);
    }

    public String getCircleName(int id) throws SQLException {
        String sql = "SELECT name FROM circle WHERE id=?";
        return getJdbcTemplate().queryForObject(sql, new Object[] {id}, String.class);
    }

    public Circle getCircleObject(int id){
        String sql = "SELECT * FROM circle WHERE id=?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, new circleMapper());
    }

    public List<Circle> getListOfAllCircles(){
        String sql = "SELECT * FROM circle";
        return getJdbcTemplate().query(sql, new circleMapper());
    }

    private static final class circleMapper implements RowMapper<Circle>{

        public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt("id"));
            circle.setName(resultSet.getString("name"));
            return circle;
        }
    }

    /*public void insertCircleUsingNamedParameters(Circle circle){
        String sql = "INSERT INTO circle (id, name) values (:id, :name)";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("id", circle.getId());
        namedParameters.put("name", circle.getName());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }*/
}
