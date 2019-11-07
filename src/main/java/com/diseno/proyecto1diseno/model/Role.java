/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Charlie
 */
@Entity
@Table(name="roles")
public class Role {
    private static int CID = 0;
    @Id
    private int id;
    String name;
    float salary;
    Task[] task;

    public Role(String name, float salary, Task[] task) {
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

    public Task[] getTask() {
        return task;
    }

    public void setTask(Task[] task) {
        this.task = task;
    }
    
    
}
