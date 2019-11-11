/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Charlie
 */
@Entity
@Table(name="roles")
public class Role {
    private static int CID = 0;
    @Id
    @GeneratedValue
    private int id;
    String name;
    float salary;
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Task> task = new ArrayList<>();

    public Role(String name, float salary, List<Task> task) {
        this.id = CID++;
        this.name = name;
        this.salary = salary;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    
    
    
}
