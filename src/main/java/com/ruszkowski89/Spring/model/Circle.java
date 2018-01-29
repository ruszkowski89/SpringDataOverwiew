package com.ruszkowski89.Spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Circle {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Circle(int id, String name) {
        setId(id);
        setName(name);
    }

    public Circle() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
