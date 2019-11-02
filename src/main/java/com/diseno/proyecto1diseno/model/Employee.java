/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

/**
 *
 * @author Charlie
 * 
 * TODO
 * -add studies
 * 
 * 
 */
public class Employee extends User{
    Role[] roles;
    Calification[] califications;

    public Employee(int id, String name, String phone, String email,Role[] roles,Calification[] califications) {
        super(id, name, phone, email); 
        this.roles = roles;
        this.califications = califications;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    public Calification[] getCalifications() {
        return califications;
    }

    public void setCalifications(Calification[] califications) {
        this.califications = califications;
    }
    
    
    
    
}
