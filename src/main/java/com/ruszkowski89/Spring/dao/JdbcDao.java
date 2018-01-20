package com.ruszkowski89.Spring.dao;

import com.ruszkowski89.Spring.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    //private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /*public void insertCircleUsingNamedParameters(Circle circle){
        String sql = "INSERT INTO circle (id, name) values (:id, :name)";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("id", circle.getId());
        namedParameters.put("name", circle.getName());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }*/

    public void insertCircle(Circle circle){
        String sql = "INSERT INTO circle (id, name) values (?, ?)";
        jdbcTemplate.update(sql, circle.getId(), circle.getName());
    }

    public void updateCircleName(int id, String newName){
        String sql = "UPDATE circle SET name='" + newName + "' WHERE id=" + id;
        jdbcTemplate.update(sql);
    }

    public String getCircleName(int id) throws SQLException {
        String sql = "SELECT name FROM circle WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
    }

    public Circle getCircleObject(int id){
        String sql = "SELECT * FROM circle WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new circleMapper());
    }

    public List<Circle> getListOfAllCircles(){
        String sql = "SELECT * FROM circle";
        return jdbcTemplate.query(sql, new circleMapper());
    }

    private static final class circleMapper implements RowMapper<Circle>{

        public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt("id"));
            circle.setName(resultSet.getString("name"));
            return circle;
        }
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        //this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /*public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }*/

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }





}
