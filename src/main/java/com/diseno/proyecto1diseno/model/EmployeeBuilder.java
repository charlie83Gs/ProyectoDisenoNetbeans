/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class EmployeeBuilder {
    int id;
    String name;
    String phone;
    String email;
    ArrayList<Role> roles;
    ArrayList<Calification> califications;

    public EmployeeBuilder() {
        roles = new ArrayList<>();
        califications = new ArrayList<>();
        id = -1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void addRole(Role role){
        this.roles.add(role);
    }
    
    public void addCalification(Calification calification){
        this.califications.add(calification);
    }
    
    public Employee getResult(){
        Role[] roleArray = (Role[])roles.toArray();
        Calification[] calificationArray = (Calification[])califications.toArray();
        return new Employee(id,name,phone,email,roleArray,calificationArray);
        
    }
    
}
